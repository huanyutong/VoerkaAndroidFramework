package com.hyt.base.module.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;
import android.util.ArrayMap;
import android.view.ViewGroup;

import com.hyt.base.module.base.AbsModule;
import com.hyt.base.module.config.ModuleContext;
import com.hyt.base.module.manager.ModuleManager;
import com.hyt.base.module.util.ModuleFactory;

import java.util.ArrayList;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base.activity</p>
 * <p>文件名称: ActivityModuleManager</p>
 * <p>描　　述: [Activity模块管理类，负责模块的初始化，然后将初始化成功的模块交给父类 ModuleManager 进行相关方法分发]
 * 1.创建指定模块；
 * 2.指定模块依赖注入；
 * 3.初始化指定模块；
 * 4.纳入方法分发管理。
 * </p>
 * <p>创建时间: 2020-09-12 12:39</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-12] [LinShiJing][变更描述]
 */
public class ActivityModuleManager extends ModuleManager {

    /**
     * 初始化业务模块
     *
     * @param saveInstance
     * @param activity
     * @param modules
     */
    public void initModules(Bundle saveInstance, Activity activity, ArrayMap<String, ArrayList<Integer>> modules) {
        if (activity == null && modules == null) {
            return;
        }
        //配置Activity下的所有module全限定名 后续可以根据名称还原module实体（实体才包含ViewGroup、Activity等参数）
        moduleConfig(new ArrayList<>(modules.keySet()));
        //依次给所有module初始化：1.创建实体 2.传递参数 3.调用初始化 4.纳入生命周期管理
        for (String moduleName : modules.keySet()) {
            //创建对应module
            AbsModule module = ModuleFactory.newModuleInstance(moduleName);
            if (module != null) {
                //创建参数
                ModuleContext moduleContext = new ModuleContext();
                moduleContext.setActivity(activity);
                moduleContext.setSaveInstance(saveInstance);
                //关联视图
                SparseArrayCompat<ViewGroup> viewGroups = new SparseArrayCompat<>();
                ArrayList<Integer> mViewIds = modules.get(moduleName);
                if (mViewIds != null && mViewIds.size() > 0) {
                    for (int i = 0; i < mViewIds.size(); i++) {
                        viewGroups.put(i, (ViewGroup) activity.findViewById(mViewIds.get(i)));
                    }
                }
                moduleContext.setViewGroups(viewGroups);//保存视图
                //调用初始化（参数传递）
                module.setModuleContext(moduleContext);
                module.init(moduleContext);
                //纳入管理
                allModules.put(moduleName, module);//记录module的名称和信息
            }
        }
    }

}
