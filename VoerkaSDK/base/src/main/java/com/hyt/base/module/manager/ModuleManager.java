package com.hyt.base.module.manager;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.ArrayMap;

import com.hyt.base.module.base.AbsModule;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base.activity</p>
 * <p>文件名称: ModuleManager</p>
 * <p>描　　述: [模块管理，管理分发参数的传递，以及初始化每个业务模块，并且分发声明周期到每个业务模块中。]</p>
 * <p>创建时间: 2020-09-11 14:51</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-11] [LinShiJing][变更描述]
 */
public class ModuleManager {
    private ArrayMap<String, ArrayList<Integer>> modules; //模块名字（类全限定名）
    @SuppressLint("NewApi")
    protected ArrayMap<String, AbsModule> allModules = new ArrayMap<>();//模块实体

    ExecutorService pool;
    Handler handler = new Handler();

    public ExecutorService getPool() {
        if (pool == null)
            pool = Executors.newSingleThreadExecutor();
        return pool;
    }

    public Handler getHandler() {
        if (pool == null)
            handler = new Handler();
        return handler;
    }

    public ArrayMap<String, ArrayList<Integer>> getModules() {
        return modules;
    }

    /**
     * 模块配置信息
     *
     * @param modules
     */
    public void moduleConfig(ArrayMap<String, ArrayList<Integer>> modules) {
        this.modules = modules;
    }

    @SuppressLint("NewApi")
    public AbsModule getModuleByNames(String name) {
        if (!allModules.isEmpty()) {
            return allModules.get(name);
        }
        return null;
    }

    /**
     * 恢复周期
     */
    public void onResume() {
        for (AbsModule module : allModules.values()) {
            if (module != null) {
                module.onResume();
            }
        }
    }

    /**
     * 暂停周期
     */
    public void onPause() {
        for (AbsModule module : allModules.values()) {
            if (module != null) {
                module.onPause();
            }
        }
    }

    /**
     * 停止周期
     */
    public void onStop() {
        for (AbsModule module : allModules.values()) {
            if (module != null) {
                module.onStop();
            }
        }
    }

    /**
     * 配置变更周期
     *
     * @param newConfig
     */
    public void onConfigurationChanged(Configuration newConfig) {
        for (AbsModule module : allModules.values()) {
            if (module != null) {
                module.onOrientationChanges(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE);
            }
        }
    }

    /**
     * 销毁周期
     */
    public void onDestroy() {
        for (AbsModule module : allModules.values()) {
            if (module != null) {
                module.onDestroy();
            }
        }
    }
}