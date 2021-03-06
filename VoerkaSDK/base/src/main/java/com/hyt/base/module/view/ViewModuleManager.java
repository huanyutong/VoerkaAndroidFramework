package com.hyt.base.module.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.hyt.base.module.base.AbsModule;
import com.hyt.base.module.config.ModuleContext;
import com.hyt.base.module.manager.ModuleManager;
import com.hyt.base.module.util.ModuleFactory;
import com.hyt.base.module.util.ModuleUtil;

import java.util.ArrayList;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base.distribute.view</p>
 * <p>文件名称: ViewModuleManager</p>
 * <p>描　　述: [View模块管理类，负责模块的初始化]</p>
 * <p>创建时间: 2020-09-14 22:46</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-14] [LinShiJing][变更描述]
 */
public class ViewModuleManager extends ModuleManager {
    private static final String TAG = ViewModuleManager.class.getSimpleName();

    /**
     * 初始化业务模块
     *
     * @param saveInstance
     * @param activity
     * @param modules
     */
    public void initModules(Bundle saveInstance, Activity activity, View rootView, ArrayMap<String, ArrayList<Integer>> modules) {
        if (activity == null && modules == null) {
            return;
        }
        moduleConfig(modules);
        initModule(saveInstance, activity, rootView);
    }

    public void initModule(final Bundle saveIntanceState, final Activity activity, final View rootView) {
        //获取配置
        for (final String moduleName : getModules().keySet()) {
            if (ModuleUtil.empty(moduleName)) {
                return;
            }
            getPool().execute(new Runnable() {
                @Override
                public void run() {
                    Log.d(TAG, "ViewModuleManager init module name: " + moduleName);

                    final AbsModule module = ModuleFactory.newModuleInstance(moduleName);
                    if (module != null) {
                        getHandler().post(new Runnable() {
                            @Override
                            public void run() {
                                ModuleContext moduleContext = new ModuleContext();
                                moduleContext.setActivity(activity);
                                moduleContext.setSaveInstance(saveIntanceState);

                                //关联视图
                                SparseArrayCompat<ViewGroup> sVerticalViews = new SparseArrayCompat<>();
                                ArrayList<Integer> viewIds = getModules().get(moduleName);
                                if (viewIds != null && viewIds.size() > 0) {
                                    for (int i = 0; i < viewIds.size(); i++) {
                                        sVerticalViews.put(i, (ViewGroup) rootView.findViewById(viewIds.get(i).intValue()));
                                    }
                                }

                                moduleContext.setViewGroups(sVerticalViews);
                                module.init(moduleContext, saveIntanceState);

                                allModules.put(moduleName, module);
                            }
                        });
                    }
                }
            });
        }
    }
}
