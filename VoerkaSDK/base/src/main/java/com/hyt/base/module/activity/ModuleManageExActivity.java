package com.hyt.base.module.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.util.ArrayMap;
import android.util.Log;
import android.view.ViewGroup;

import com.hyt.base.R;
import com.hyt.base.module.bus.ModuleBus;
import com.hyt.base.module.config.ModuleContext;
import com.hyt.base.module.manager.ModuleExManager;
import com.hyt.base.module.model.ModuleInfo;
import com.hyt.base.module.util.ModuleFactory;
import com.hyt.base.module.view.ViewModuleManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

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
public abstract class ModuleManageExActivity extends Activity {
    private static final String TAG = ViewModuleManager.class.getSimpleName();

    private ModuleExManager moduleManager;    //Activity模块管理类
    private ModuleContext moduleContext;            //宿主相关信息

    private ViewGroup mTopViewGroup;                //顶层布局
    private ViewGroup mBottomViewGroup;             //底层布局
    private ViewGroup pluginViewGroup;              //中层布局

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_default);
        ModuleBus.getInstance().register(this);
        //设定多个层级
        mTopViewGroup = findViewById(R.id.layout_top);
        mBottomViewGroup = findViewById(R.id.layout_bottom);
        pluginViewGroup = findViewById(R.id.layout_plugin_center);
        moduleManager = new ModuleExManager();//初始化管理者
        moduleManager.moduleConfig(moduleConfig());
        initView(savedInstanceState);
    }

    @SuppressLint("NewApi")
    public void initView(final Bundle savedInstanceState) {
        moduleContext = new ModuleContext();
        moduleContext.setActivity(this);
        moduleContext.setSaveInstance(savedInstanceState);
        //关联视图
        SparseArrayCompat<ViewGroup> sVerticalViews = new SparseArrayCompat<>();
        sVerticalViews.put(ModuleContext.TOP_VIEW_GROUP, mTopViewGroup);
        sVerticalViews.put(ModuleContext.BOTTOM_VIEW_GROUP, mBottomViewGroup);
        sVerticalViews.put(ModuleContext.PLUGIN_CENTER_VIEW, pluginViewGroup);
        moduleContext.setViewGroups(sVerticalViews);

        Observable.fromIterable(moduleManager.getModules())
                .map(new Function<String, ModuleInfo>() {
                    @Override
                    public ModuleInfo apply(String name) {
                        return new ModuleInfo(name, ModuleFactory.newModuleInstance(name));
                    }
                })
                .delay(10, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModuleInfo>() {
                    @Override
                    public void accept(ModuleInfo moduleInfo) {
                        if (moduleInfo != null) {
                            long before = System.currentTimeMillis();
                            moduleInfo.module.init(moduleContext, null);
                            Log.d(STORAGE_SERVICE, "modulename:" + moduleInfo.getClass().getSimpleName() +
                                    " init time = " + (System.currentTimeMillis() - before) + "ms");
                            moduleManager.putModule(moduleInfo.name,moduleInfo.module);
                        }
                    }
                });
    }

    //获取配置列表
    public abstract List<String> moduleConfig();

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


























