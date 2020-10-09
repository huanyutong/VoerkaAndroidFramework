package com.hyt.base.module.config;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;
import android.view.ViewGroup;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base.activity</p>
 * <p>文件名称: CWModuleContext</p>
 * <p>描　　述: [宿主相关信息，保存Activity分发的三个参数，一个子模块需要注入的参数]</p>
 * <p>创建时间: 2020-09-11 14:46</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-11] [LinShiJing][变更描述]
 */
public class ModuleContext {
    public static final int TOP_VIEW_GROUP = 0;
    public static final int BOTTOM_VIEW_GROUP = 1;
    public static final int PLUGIN_CENTER_VIEW = 2;

    private Activity context;//上下文对象
    private Bundle saveInstance;//保存状态的对象
    private SparseArrayCompat<ViewGroup> viewGroups = new SparseArrayCompat<>();//布局对象(子模块所拥有的所有布局，一个模块可以有多个布局)

    public Activity getActivity() {
        return context;
    }

    public void setActivity(Activity component) {
        this.context = component;
    }

    public Bundle getSaveInstance() {
        return saveInstance;
    }

    public void setSaveInstance(Bundle saveInstance) {
        this.saveInstance = saveInstance;
    }

    public SparseArrayCompat<ViewGroup> getViewGroups() {
        return viewGroups;
    }

    public void setViewGroups(SparseArrayCompat<ViewGroup> viewGroups) {
        this.viewGroups = viewGroups;
    }

    public ViewGroup getView(int key){
        return viewGroups.get(key);
    }
}
