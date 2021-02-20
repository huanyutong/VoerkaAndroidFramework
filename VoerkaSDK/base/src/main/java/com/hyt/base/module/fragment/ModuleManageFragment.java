package com.hyt.base.module.fragment;

import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.ArrayMap;
import android.view.View;

import java.util.ArrayList;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base.distribute.fragment</p>
 * <p>文件名称: ModuleManageFragment</p>
 * <p>描　　述: [Fragment的模块管理抽象类，负责与模块管理类通信]</p>
 * <p>创建时间: 2020-09-12 22:52</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-12] [LinShiJing][变更描述]
 */
public abstract class ModuleManageFragment extends Fragment {
    private View rootView;
    private FragmentModuleManager moduleManager;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rootView = view;
        if (empty()) {
            //模块管理初始化
            moduleManager = new FragmentModuleManager();
            moduleManager.initModules(savedInstanceState, getActivity(), rootView, moduleConfig());
        }
    }

    public abstract ArrayMap<String, ArrayList<Integer>> moduleConfig();

    /**
     * 模块管理者是否为空
     *
     * @return
     */
    private boolean empty() {
        return moduleManager == null;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!empty()) {
            moduleManager.onResume();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (!empty()) {
            moduleManager.onStop();
        }
    }

    @Override
    public void onDestroy() {
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






















