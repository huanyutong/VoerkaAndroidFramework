package com.hyt.base.module.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;

import java.util.ArrayList;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base.distribute.view</p>
 * <p>文件名称: ModuleManageView</p>
 * <p>描　　述: [View的模块管理抽象类，负责与模块管理类通信]</p>
 * <p>创建时间: 2020-09-14 22:45</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-14] [LinShiJing][变更描述]
 */
public abstract class ModuleManageView extends View {
    private ViewModuleManager moduleManager;

    public ModuleManageView(Context context) {
        super(context);
    }

    public ModuleManageView(Context context, Bundle savedInstanceState, View rootView) {
        super(context);
        moduleManager = new ViewModuleManager();//初始化管理者
        moduleManager.initModules(savedInstanceState, (Activity) context, rootView, moduleConfig());
    }

    public abstract ArrayMap<String, ArrayList<Integer>> moduleConfig();

    public void onResume() {
        if (moduleManager != null) {
            moduleManager.onResume();
        }
    }

    public void onStop() {
        if (moduleManager != null) {
            moduleManager.onStop();
        }
    }

    public void onDestroy() {
        if (moduleManager != null) {
            moduleManager.onDestroy();
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (moduleManager != null) {
            moduleManager.onConfigurationChanged(newConfig);
        }
    }
}
