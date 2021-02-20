package com.hyt.annotation;

import com.hyt.enums.LayoutLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.annotation</p>
 * <p>文件名称: com.hyt.annotation.ModuleUnit</p>
 * <p>描　　述: [Module单元注解 用于记录每个module配置相关的信息]</p>
 * <p>创建时间: 2020-09-12 21:52</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-12] [LinShiJing][变更描述]
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface ModuleUnit {
    String templet() default "normal";//设定模板名称

    String title() default "DanMu";//业务模板名称

    LayoutLevel layoutlevel() default LayoutLevel.NORMAL;//层级编排

    int extralevel() default 0;//层级内排序
}