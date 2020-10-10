package com.hyt.main.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyt.base.module.fragment.ModuleManageFragment;
import com.hyt.base.module.view.ModuleManageView;
import com.hyt.main.R;

import java.util.ArrayList;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.main.fragment</p>
 * <p>文件名称: DanmuFragment</p>
 * <p>描　　述: [用一句话描述该文件做什么]</p>
 * <p>创建时间: 2020-09-14 23:01</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-14] [LinShiJing][变更描述]
 */
public class DanmuFragment extends ModuleManageFragment {
    private ModuleManageView moduleManageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        moduleManageView = new ModuleManageView(getActivity(), savedInstanceState,
                view.findViewById(R.id.danmu)) {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public ArrayMap<String, ArrayList<Integer>> moduleConfig() {
                ArrayMap<String, ArrayList<Integer>> map = new ArrayMap<>();
                map.put(PageConfig.MODULE_DANMU, new ArrayList<Integer>() {{
                    add(R.id.danmu);
                }});
                return map;
            }
        };
        return view;
    }

    @Override
    public ArrayMap<String, ArrayList<Integer>> moduleConfig() {
        return null;
    }
}
