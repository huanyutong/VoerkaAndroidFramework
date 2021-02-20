package com.hyt.base.module.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hyt.base.module.config.ModuleContext;

import java.util.ArrayList;
import java.util.List;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base.distribute.base</p>
 * <p>文件名称: BasicModule</p>
 * <p>描　　述: [用一句话描述该文件做什么]</p>
 * <p>创建时间: 2020-09-15 11:54</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-15] [LinShiJing][变更描述]
 */
public class BasicExModule extends AbsModule {
    public Activity contetxt;           //宿主Activity
    public FragmentActivity mContext;   //宿主FragmentActivity
    public ModuleContext moduleContext; //宿主相关信息
    public Handler handler;
    public ViewGroup parentTop;         //顶层布局
    public ViewGroup parentBottom;      //底层布局
    public ViewGroup parentCenter;      //中层布局
    public View own;                    //宿主View
    public List<View> viewList = new ArrayList<>();

//    public void setModuleContext(ModuleContext moduleContext) {
//        this.moduleContext = moduleContext;
//    }

    public void setContentView(int layoutResID){
        LayoutInflater.from(contetxt.getApplicationContext()).inflate(layoutResID, moduleContext.getViewGroups().get(0), true);
    }

    @Override
    public void init(ModuleContext moduleContext, Bundle extend) {
        this.moduleContext = moduleContext;
        contetxt = moduleContext.getActivity();
        parentTop = moduleContext.getView(ModuleContext.TOP_VIEW_GROUP);
        parentBottom = moduleContext.getView(ModuleContext.BOTTOM_VIEW_GROUP);
        parentCenter = moduleContext.getView(ModuleContext.PLUGIN_CENTER_VIEW);
        handler = new Handler();
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

    /**
     * 查找控件
     * @param id 控件ID
     * @param <T> 控件范型
     * @return
     */
    public <T extends View> T findViewById(int id) {
        if (moduleContext != null && moduleContext.getViewGroups() != null) {
            if (moduleContext.getViewGroups().size() > 0) {
                return moduleContext.getViewGroups().get(0).findViewById(id);
            }
        }
        return null;
    }

    /**
     * 吐司
     * @param text
     * @param duration
     */
    public void showToast(CharSequence text,int duration){
        Toast.makeText(moduleContext.getActivity(),text,duration).show();
    }
}
