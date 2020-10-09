package com.hyt.base.module.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.hyt.base.module.base.AbsModule;
import com.hyt.base.module.config.ModuleContext;
import com.hyt.base.module.util.ModuleFactory;
import com.hyt.base.module.manager.ModuleManager;

import java.util.ArrayList;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base.distribute.fragment</p>
 * <p>文件名称: FragmentModuleManager</p>
 * <p>描　　述: [Fragment模块管理类，负责模块的初始化]</p>
 * <p>创建时间: 2020-09-12 22:54</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-12] [LinShiJing][变更描述]
 */
public class FragmentModuleManager extends ModuleManager {
    private final String TAG = this.getClass().getSimpleName();

    public void initModules(Bundle saveInstance, Activity activity, View rootView, ArrayMap<String, ArrayList<Integer>> modules){
        if(activity==null||modules==null){
            return;
        }
        moduleConfig(new ArrayList<>(modules.keySet()));

        //获取配置
        for(String moduleName:modules.keySet()){
            Log.d(TAG,"FragmentModuleManager init module name:"+moduleName);
            //创建模块
            AbsModule module = ModuleFactory.newModuleInstance(moduleName);
            if(module!=null){
                ModuleContext moduleContext = new ModuleContext();
                //关联Activity
                moduleContext.setActivity(activity);
                moduleContext.setSaveInstance(saveInstance);
                //关联视图
                SparseArrayCompat<ViewGroup> viewGroups = new SparseArrayCompat<>();
                ArrayList<Integer> viewIds = modules.get(moduleName);
                if(viewIds!=null&&viewIds.size()>0){
                    for(int i=0;i<viewIds.size();i++) {
                        //添加视图到视图列表
                        viewGroups.put(i, (ViewGroup) rootView.findViewById(viewIds.get(i).intValue()));
                    }
                }
                moduleContext.setViewGroups(viewGroups);//保存视图
                module.init(moduleContext);//初始化各个module
                allModules.put(moduleName,module);
            }
        }
    }
}
















