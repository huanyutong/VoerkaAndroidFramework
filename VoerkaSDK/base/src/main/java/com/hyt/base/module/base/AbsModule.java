package com.hyt.base.module.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.hyt.base.module.config.ModuleContext;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base.activity</p>
 * <p>文件名称: CWAbsExModule</p>
 * <p>描　　述: [模块基类，全部业务模块的实现都需要继承CWAbsModule抽象类,初始化模块功能,生命周期触发,保存状态触发]</p>
 * <p>创建时间: 2020-09-12 12:26</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-12] [LinShiJing][变更描述]
 */
public abstract class AbsModule {
    private ModuleContext moduleContext;

    public <T extends View> T findViewById(int id) {
        if (moduleContext != null && moduleContext.getViewGroups() != null) {
            if (moduleContext.getViewGroups().size() > 0) {
                return moduleContext.getViewGroups().get(0).findViewById(id);
            }
        }
        return null;
    }

    public void setModuleContext(ModuleContext moduleContext) {
        this.moduleContext = moduleContext;
    }

    public void setContentView(int layoutResID){
        LayoutInflater.from(moduleContext.getActivity()).inflate(layoutResID, moduleContext.getViewGroups().get(0), true);
    }

    public void showToast(CharSequence text,int duration){
        Toast.makeText(moduleContext.getActivity(),text,duration).show();
    }

    /**
     * 初始化模块功能，初始化将AbsModule的参数传入
     *
     * @param moduleContext
     * @return
     */
    public abstract void init(ModuleContext moduleContext,String extend);

    /**
     * 保存状态触发
     *
     * @param outState
     */
    public abstract void onSaveInstanceState(Bundle outState);

    /**
     * 生命周期触发
     */
    public abstract void onResume();//恢复周期

    public abstract void onPause();//暂停周期

    public abstract void onStop();//停止周期

    public abstract void onOrientationChanges(boolean isLandscape);//配置变更周期

    public abstract void onDestroy();//销毁周期
}
