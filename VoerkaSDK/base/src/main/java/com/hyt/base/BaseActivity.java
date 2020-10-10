package com.hyt.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base</p>
 * <p>文件名称: BaseActivity</p>
 * <p>描　　述: [Activity抽象基类]</p>
 * <p>创建时间: 2020-09-08 17:28</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-08] [LinShiJing][变更描述]
 */
public abstract class BaseActivity extends Activity {

    /**
     * .日志标签
     */
    private String tag = this.getClass().getSimpleName();

    /**
     * .重写onCreate
     *
     * @param savedInstanceState 状态
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(tag, "Activity:" + tag + ":Common:onCreate:在创建启动时调用:启动(1)"
                + ":内存杀死Activity(1)");
    }

    /**
     * .重写onStart
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "Activity:" + tag
                + ":Common:onStart:处于可见状态时调用:启动(2):返回Activity(2):内存杀死Activity(2)");
    }

    /**
     * .重写onRestart
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "Activity:" + tag + ":onRestart:返回Activity(1)");
    }

    /**
     * .重写onResume
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "Activity:" + tag
                + ":Common:onResume:Activity显示在UI顶层时被调用:启动(3):返回Activity(3)"
                + ":内存杀死Activity(3)");
    }

    /**
     * .重写onPause
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "Activity:" + tag
                + ":Common:onPause:Activity不在UI顶层，但依然可见（如弹框）:销毁(1)"
                + ":跳转新Activity或按home键:(1):按Back退出Activity(1)");
    }

    /**
     * .重写onStop
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "Activity:" + tag
                + ":Common:onStop:Activity处于不可见状态时调用:销毁(2):跳转新Activity或按home键:(1)"
                + ":按Back退出Activity(2)");
    }

    /**
     * .重写onDestroy
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "Activity:" + tag
                + ":Common:onDestroy:当Activity退出时调用:销毁(3):按Back退出Activity(3)");
    }

    /**
     * .获取View
     *
     * @param id  资源ID
     * @param <T> 控件
     * @return
     */
    protected <T extends View> T generateFindViewById(int id) {
        return (T) findViewById(id);
    }
}
