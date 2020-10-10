package com.hyt.base;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base</p>
 * <p>文件名称: BaseClass</p>
 * <p>描　　述: [Class基类，书写格式范例]</p>
 * <p>创建时间: 2020-10-09 22:22</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-10-09] [LinShiJing][变更描述]
 */
class BaseClass {

    /**
     * .变量
     */
    String name;

    /**
     * .构造函数
     */
    public BaseClass() {
    }

    /**
     * .<p>@title: 一句话功能描述</p>
     * <p>@description: 功能详细描述</p>
     *
     * @param name 名称
     * @param type 类型
     * @return void
     * @exception throws [异常类型] [异常说明].
     * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
     * @createDate 2020-10-09 22:32</p>
     * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
     * @update [1][日期2020-10-09] [LinShiJing][变更描述]
     **/
    protected void test(String name, int type) {
        // 待办事宜 TODO: [LinShiJing] [2020/10/10] [预计处理时间] 
        // 错误，不能工作 FIXME: [LinShiJing] [2020/10/10] [预计处理时间] 
    }

    /**
     * .公有方法或保护方法
     */
    public void read() {
    }


    /**
     * .私有方法
     */
    private void write() {
    }

    /**
     * .getter/setter方法
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
