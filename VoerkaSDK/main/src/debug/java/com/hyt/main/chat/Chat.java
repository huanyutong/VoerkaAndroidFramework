package com.hyt.main.chat;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyt.base.module.base.AbsModule;
import com.hyt.base.module.config.ModuleContext;
import com.hyt.main.R;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base.activity.module</p>
 * <p>文件名称: com.hyt.main.danmu.Danmu</p>
 * <p>描　　述: [弹幕模块]</p>
 * <p>创建时间: 2020-09-12 21:52</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-12] [LinShiJing][变更描述]
 */
public class Chat extends AbsModule {
    private Activity activity;
    private ViewGroup parentViewGroup;
    private View contentView;

    @Override
    public void init(ModuleContext moduleContext) {
        activity = moduleContext.getActivity();
        parentViewGroup = moduleContext.getViewGroups().get(0);
        initView();
    }

    private void initView() {
        contentView = LayoutInflater.from(activity).inflate(R.layout.activity_chat, parentViewGroup, true);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onOrientationChanges(boolean isLandscape) {

    }

    @Override
    public void onDestroy() {

    }

}
