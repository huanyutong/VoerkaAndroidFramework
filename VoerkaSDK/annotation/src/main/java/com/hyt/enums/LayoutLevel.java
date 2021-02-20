package com.hyt.enums;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.annotation</p>
 * <p>文件名称: com.hyt.annotation.ModuleMeta</p>
 * <p>描　　述: [模块等级枚举]</p>
 * <p>创建时间: 2020-09-12 21:52</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-12] [LinShiJing][变更描述]
 */
public enum LayoutLevel {
    //    VERY_LOW,
    //    LOW,
    //    NORMAL,
    //    HIGHT,
    //    VERY_HIGHT;

    VERY_LOW(500, "非常低"),
    LOW(400, "低"),
    NORMAL(300, "正常"),
    HIGHT(200, "高"),
    VERY_HIGHT(100, "非常高");

    private int code;
    private String value;

    LayoutLevel(int code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.name() + "(" + this.code + "," + this.value + ")";
    }

    /**
     * 根据code获取message
     *
     * @param code
     * @return
     */
    public static String getMessage(int code) {
        //通过enum.values()获取所有的枚举值
        for (LayoutLevel layoutLevel : LayoutLevel.values()) {
            //通过enum.get获取字段值
            if (layoutLevel.getCode() == code) {
                return layoutLevel.value;
            }
        }
        return null;
    }

    /**
     * 根据code获取CodeAndMessage
     *
     * @param code
     * @return
     */
    public static LayoutLevel getCodeAndMessage(int code) {
        for (LayoutLevel layoutLevel : LayoutLevel.values()) {
            if (layoutLevel.getCode() == code) {
                return layoutLevel;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
