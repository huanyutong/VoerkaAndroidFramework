package com.hyt.model;

import com.hyt.annotation.ModuleUnit;
import com.hyt.enums.LayoutLevel;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.annotation</p>
 * <p>文件名称: com.hyt.annotation.ModuleMeta</p>
 * <p>描　　述: [模块信息实体 当ModuleCenter启动时汇总模块信息]</p>
 * <p>创建时间: 2020-09-12 21:52</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-12] [LinShiJing][变更描述]
 */
public class ModuleMeta {
    public String templet;          //模板名称
    public String moduleName;       //模块名称
    public String title;            //业务模板名称
    public LayoutLevel layoutlevel; //模块层级
    public int extralevel;          //层级内排序

    public ModuleMeta(String templet, String moduleName, String title, int layoutlevel, int extralevel) {
        this.templet = templet;
        this.moduleName = moduleName;
        this.title = title;
        if (layoutlevel == 500) {//层级默认为五层
            this.layoutlevel = LayoutLevel.VERY_LOW;
        } else if (layoutlevel == 400) {
            this.layoutlevel = LayoutLevel.LOW;
        } else if (layoutlevel == 300) {
            this.layoutlevel = LayoutLevel.NORMAL;
        } else if (layoutlevel == 200) {
            this.layoutlevel = LayoutLevel.HIGHT;
        } else if (layoutlevel == 100) {
            this.layoutlevel = LayoutLevel.VERY_HIGHT;
        }
        this.extralevel = extralevel;
    }

    /**
     * 提供给编译时注解中使用
     *
     * @param unit       模块单元注解
     * @param moduleName 模块名称
     */
    public ModuleMeta(ModuleUnit unit, String moduleName) {
        this.moduleName = moduleName;
        this.templet = unit.templet();
        this.layoutlevel = unit.layoutlevel();
        this.extralevel = unit.extralevel();
        this.title = unit.title();
    }
}
