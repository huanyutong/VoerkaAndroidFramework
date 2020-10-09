package com.hyt.main;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.ArrayMap;

import com.hyt.base.module.activity.ModuleManageActivity;
import com.hyt.main.fragment.PageConfig;

import java.util.ArrayList;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base.activity</p>
 * <p>文件名称: com.hyt.main.ModuleMainActivity</p>
 * <p>描　　述: [用一句话描述该文件做什么]</p>
 * <p>创建时间: 2020-09-12 13:15</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-12] [LinShiJing][变更描述]
 */
public class ModuleMainActivity extends ModuleManageActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    /**
     * 设定不同模块使用的布局
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public ArrayMap<String, ArrayList<Integer>> moduleConfig() {
        ArrayMap<String, ArrayList<Integer>> map = new ArrayMap<>();
        map.put(PageConfig.MODULE_DANMU, new ArrayList<Integer>() {{
            add(R.id.danmu);
        }});
        map.put(PageConfig.MODULE_CHAT, new ArrayList<Integer>() {{
            add(R.id.chat);
        }});
        map.put(PageConfig.MODULE_LIVE, new ArrayList<Integer>() {{
            add(R.id.live);
        }});
        return map;
    }
}
















