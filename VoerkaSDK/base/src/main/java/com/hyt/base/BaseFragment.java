package com.hyt.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base</p>
 * <p>文件名称: BaseFragment</p>
 * <p>描　　述: [用一句话描述该文件做什么]</p>
 * <p>创建时间: 2020-09-08 17:28</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-08] [LinShiJing][变更描述]
 */
public class BaseFragment extends Fragment {
    private String TAG = this.getClass().getSimpleName();

    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "Fragment:" + TAG + ":onAttach:Fragment与Activity建立关联时被调用，用于获得Activity传递的值:Fragment创建(1)");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "Fragment:" + TAG + ":Common:onCreate:Fragment创建(2)");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "Fragment:" + TAG + ":onCreateView:在创建Fragment时调用:Fragment创建(3)");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "Fragment:" + TAG + ":onActivityCreated:在初始化onCreateView方法的视图后返回时被调用:Fragment创建(4)");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(TAG, "Fragment:" + TAG + ":Common:onStart:Fragment可见(1)");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(TAG, "Fragment:" + TAG + ":Common:onResume:Fragment可见(2)");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "Fragment:" + TAG + ":Common:onPause:Fragment进入后台不可见状态(1):Fragment销毁(1)");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "Fragment:" + TAG + ":Common:onStop:Fragment进入后台不可见状态(2):Fragment销毁(2)");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "Fragment:" + TAG + ":onDestroyView:在Fragment视图被移除时调用:Fragment销毁(3)");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "Fragment:" + TAG + ":Common:onDestroy:Fragment销毁(4)");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "Fragment:" + TAG + ":onDetach:Fragment与Activity的关联被取消时调用:Fragment销毁(5)");
        super.onDetach();
    }
}
