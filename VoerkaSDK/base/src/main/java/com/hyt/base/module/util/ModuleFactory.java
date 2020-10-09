package com.hyt.base.module.util;

import android.text.TextUtils;

import com.hyt.base.module.base.AbsModule;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base.activity</p>
 * <p>文件名称: CWModuleFactory</p>
 * <p>描　　述: [模块创建工厂]</p>
 * <p>创建时间: 2020-09-12 14:25</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-12] [LinShiJing][变更描述]
 */
public class ModuleFactory {
    /**
     * 反射初始化对应module
     *
     * @param name 模块名称
     * @return
     */
    public static AbsModule newModuleInstance(String name) {
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        try {
            Class<? extends AbsModule> moduleClazz = (Class<? extends AbsModule>) Class.forName(name);
            return moduleClazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}












