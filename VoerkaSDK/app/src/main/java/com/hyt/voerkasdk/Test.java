package com.hyt.voerkasdk;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.voerkasdk</p>
 * <p>文件名称: Test</p>
 * <p>描　　述: [用一句话描述该文件做什么]</p>
 * <p>创建时间: 2020-10-09 14:40</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-10-09] [LinShiJing][变更描述]
 */
class Test extends Activity {
    private String name;

    public void write() {
        int i = 1 + 1;
        System.out.print(i + " is a number.");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(0);
    }

    /**
     * <p>@title: 一句话功能描述</p>
     * <p>@description: 功能详细描述</p>
     * 
     * @return 
     * @exception/throws [异常类型] [异常说明]
     * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
     * @createDate 2020-10-09 17:45</p> 
     * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]  
     * @update [1][日期2020-10-09] [LinShiJing][变更描述]    
     **/
    private void initView(int name) {
        
    }
    
}