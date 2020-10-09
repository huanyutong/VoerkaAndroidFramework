package com.hyt.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base</p>
 * <p>文件名称: BaseApplication</p>
 * <p>描　　述: [用一句话描述该文件做什么]</p>
 * <p>创建时间: 2020-09-08 17:29</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-08] [LinShiJing][变更描述]
 */
public class BaseApplication extends Application implements Application.ActivityLifecycleCallbacks {
    private String TAG = this.getClass().getSimpleName();
    private Activity mContext;

    /**
     * 程序创建的时候执行
     */
    @Override
    public void onCreate() {
        Log.d(TAG, "Application:" + TAG + ":onCreate");
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
    }

    /**
     * 程序终止的时候执行
     */
    @Override
    public void onTerminate() {
        Log.d(TAG, "Application:" + TAG + ":onTerminate");
        super.onTerminate();
        unregisterActivityLifecycleCallbacks(this);
    }

    /**
     * 低内存的时候执行
     */
    @Override
    public void onLowMemory() {
        Log.d(TAG, "Application:" + TAG + ":onLowMemory");
        super.onLowMemory();
    }

    /**
     * 程序在内存清理的时候执行
     *
     * @param level
     */
    @Override
    public void onTrimMemory(int level) {
        Log.d(TAG, "Application:" + TAG + ":onTrimMemory");
        super.onTrimMemory(level);
    }

    /**
     * 配置改变时，例如手机屏幕旋转等
     *
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d(TAG, "Application:" + TAG + ":onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }

    /**
     * 监听App内所有Activity的生命周期
     *
     * @param activity
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "Application:" + TAG + ":onActivityCreated:" + activity.getLocalClassName());
        mContext = activity;
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        Log.d(TAG, "Application:" + TAG + ":onActivityStarted:" + activity.getLocalClassName());
    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {
        Log.d(TAG, "Application:" + TAG + ":onActivityResumed:" + activity.getLocalClassName());
        mContext = activity;
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {
        Log.d(TAG, "Application:" + TAG + ":onActivityPaused:" + activity.getLocalClassName());
    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {
        Log.d(TAG, "Application:" + TAG + ":onActivityStopped:" + activity.getLocalClassName());
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
        Log.d(TAG, "Application:" + TAG + ":onActivitySaveInstanceState:" + activity.getLocalClassName());
    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        Log.d(TAG, "Application:" + TAG + ":onActivityDestroyed:" + activity.getLocalClassName());
    }

    /**
     * 获取底层Activity对象
     * @return
     */
    public Activity getTopActivity() {
        Log.d(TAG, "Application:" + TAG + ":getTopActivity:" + mContext.getLocalClassName());
        return mContext;
    }
}
