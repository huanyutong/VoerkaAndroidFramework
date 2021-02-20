package com.hyt.process;

import com.google.auto.service.AutoService;
import com.hyt.annotation.ModuleUnit;
import com.hyt.model.ModuleMeta;
import com.hyt.util.ModuleUtil;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;

import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.annotation</p>
 * <p>文件名称: com.hyt.annotation.ModuleMeta</p>
 * <p>描　　述: [模块信息实体 当ModuleCenter启动时汇总模块信息]</p>
 * <p>创建时间: 2020-09-12 21:52</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-12] [LinShiJing][变更描述]
 */
@AutoService(Processor.class)//自动运行编译时注解文件
public class ModuleUnitProcessor extends AbstractProcessor {
    //保存业务模块信息
    private Map<String, ModuleMeta> groupMap = new HashMap<>();
    private Filer mFiler;//文件工具，写入class文件到硬盘地址中
//    private Logger logger;//日志打印工具
    private Types types;
    private Elements elements;//文件环境信息

    /**
     * 初始化调用
     *
     * @param processingEnv 编译时环境变量
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mFiler = processingEnv.getFiler();//Generate class.
//        logger = new Logger(processingEnv.getMessager());//Package the log utils
        types = processingEnv.getTypeUtils();//Get type utils
        elements = processingEnv.getElementUtils();//Get class meta
//        logger.info("ModuleUnit init");
    }

    /**
     * 编译时注解运行
     *
     * @param set
     * @param roundEnvironment
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (CollectionUtils.isNotEmpty(set)) {//判断不为空
            //获取ModuleUnit注解对象信息
            Set<? extends Element> modulesElements = roundEnvironment.getElementsAnnotatedWith(ModuleUnit.class);
            try {
//                logger.info(">>> Found moduleUnit,start... <<<");
                //解析注解对象信息并编写Java方法
                parseModulesGroup(modulesElements);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 声明需要支持的注解类型
     *
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(ModuleUnit.class.getCanonicalName());
        return annotations;
    }

    /**
     * 使用的Java版本
     *
     * @return
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    private void parseModulesGroup(Set<? extends Element> modulesElements) throws IOException {
        if (CollectionUtils.isNotEmpty(modulesElements)) {
//            logger.info(">>> Found moduleUnit,size if" + modulesElements.size() + " <<<");
            //ModuleMeta类
            ClassName moduleMetaCn = ClassName.get(ModuleMeta.class);
            //Set<ModuleMeta>参数类型声明
            ParameterizedTypeName inputMapTypeOfGroup = ParameterizedTypeName.get(
                    ClassName.get(Set.class),
                    ClassName.get(ModuleMeta.class)
            );

            //group参数
            ParameterSpec groupParamSpec = ParameterSpec.builder(inputMapTypeOfGroup, "metaSet").build();

            //添加loadInto方法
            MethodSpec.Builder loadIntoMethodOfRootBuilder = MethodSpec.methodBuilder(ModuleUtil.METHOD_LOAD_INTO)
                    .returns(void.class)
                    .addAnnotation(Override.class)
                    .addModifiers(Modifier.PUBLIC)
                    .addParameter(groupParamSpec);

            //循环遍历注解
            for (Element element : modulesElements) {
                ModuleUnit moduleUnit = element.getAnnotation(ModuleUnit.class);
                ClassName name = ClassName.get((TypeElement) element);
                //获取类名信息
                String address = name.packageName() + "." + name.simpleName();
                //真实模块入口地址：包名+类名
                ModuleMeta moduleMeta = new ModuleMeta(moduleUnit, address);
                //构造模块信息
                groupMap.put(element.getSimpleName().toString(), moduleMeta);

                //分隔地址名
                String[] nameZone = splitDot(moduleMeta.moduleName);
                moduleMeta.title = !moduleMeta.title.equals("Danmu") ? moduleMeta.title : nameZone[nameZone.length - 1];//获取类名

                String[] templets = split(moduleMeta.templet);//获取模板名数组
                for (String templet : templets) {//添加业务模块到声明模板中
                    loadIntoMethodOfRootBuilder.addStatement("metaSet.add(new $T($S,$S,$S,$L,$L))",
                            moduleMetaCn,
                            templet,
                            moduleMeta.moduleName,
                            moduleMeta.title,
                            moduleMeta.layoutlevel.getValue(),
                            moduleMeta.extralevel

                    );
                }

//                logger.info(">>> build moduleUnit,moduleMeta = " + moduleMeta.toString() + " <<<");

                //构造Java文件
                JavaFile.builder(ModuleUtil.FACADE_PACKAGE,//指定包名
                        TypeSpec.classBuilder(ModuleUtil.NAME_OF_MODULEUNIT + name.simpleName())//构造类
                                .addJavadoc(ModuleUtil.WARNING_TIPS)//构造注释
                                .addSuperinterface(ClassName.get(elements.getTypeElement(ModuleUtil.IMODULE_UNIT)))//继承接口
                                .addModifiers(Modifier.PUBLIC)//修饰符
                                .addMethod(loadIntoMethodOfRootBuilder.build())//添加方法
                                .build()
                ).build().writeTo(mFiler);//写到硬盘地址中
            }
        }
    }

    /**
     * 分隔载入模块名
     *
     * @param groupName
     * @return
     */
    private String[] splitDot(String groupName) {
        return groupName.split("\\.");
    }

    /**
     * 分隔载入多模板
     *
     * @param groupName
     * @return
     */
    private String[] split(String groupName) {
        return groupName.split(",");
    }
}
