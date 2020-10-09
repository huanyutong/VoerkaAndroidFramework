package com.hyt.base.module.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;

import com.hyt.base.module.manager.ModuleManager;

import java.util.ArrayList;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base.distribute.view</p>
 * <p>文件名称: ViewModuleManager</p>
 * <p>描　　述: [View模块管理类，负责模块的初始化]</p>
 * <p>创建时间: 2020-09-14 22:46</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-14] [LinShiJing][变更描述]
 */
public class ViewModuleManager extends ModuleManager {
    /**
     * 初始化业务模块
     *
     * @param saveInstance
     * @param activity
     * @param modules
     */
    public void initModules(Bundle saveInstance, Activity activity, View rootView, ArrayMap<String, ArrayList<Integer>> modules) {
        if (activity == null && modules == null) {
            return;
        }
    }
}
