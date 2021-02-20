package com.hyt.base.module.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.util.ArrayMap;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.hyt.base.module.config.ModuleContext;

import java.util.ArrayList;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base.activity</p>
 * <p>文件名称: ModuleManageActivity</p>
 * <p>描　　述: [Activity的模块管理抽象类，负责与模块管理类通信]</p>
 * <p>创建时间: 2020-09-12 12:58</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-12] [LinShiJing][变更描述]
 */
public abstract class ModuleManageActivity extends Activity {
    private ActivityModuleManager moduleManager;
    private ModuleContext moduleContext;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onInit(savedInstanceState);
    }

    /**
     * 监听创建模块管理者
     *
     * @param savedInstanceState
     */
    private void onInit(@Nullable final Bundle savedInstanceState) {
        //布局onLayout时初始化
        ViewTreeObserver observer = getWindow().getDecorView().getRootView().getViewTreeObserver();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            observer.addOnWindowAttachListener(new ViewTreeObserver.OnWindowAttachListener() {
                @Override
                public void onWindowAttached() {
                    initModuleManager(savedInstanceState);//初始化模块管理者
                }

                @Override
                public void onWindowDetached() {

                }
            });
        } else {
            observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    initModuleManager(savedInstanceState);//初始化模块管理者
                }
            });
        }
    }

    /**
     * 初始化模块管理者
     *
     * @param savedInstanceState
     */
    private void initModuleManager(Bundle savedInstanceState) {
        if (empty()) {
            long ti = System.currentTimeMillis();
            moduleManager = new ActivityModuleManager();//初始化管理者
            moduleManager.initModules(savedInstanceState, this, moduleConfig());
            Log.v("ModuleManageActivity", "init use time =" + (System.currentTimeMillis() - ti));
        }
    }

    //获取配置列表
    public abstract ArrayMap<String, ArrayList<Integer>> moduleConfig();

    /**
     * 模块管理者是否为空
     * @return
     */
    private boolean empty() {
        return moduleManager == null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!empty()) {
            moduleManager.onResume();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (!empty()) {
            moduleManager.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!empty()) {
            moduleManager.onDestroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (!empty()) {
            moduleManager.onConfigurationChanged(newConfig);
        }
    }
}


























