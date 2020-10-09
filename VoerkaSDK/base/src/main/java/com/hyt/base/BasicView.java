package com.hyt.base;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/*
 * All rights Reserved, Designed By www.huanyutong.com
 * <p>项目名称: VoerkaSDK</p>
 * <p>包　　名: com.hyt.base.distribute.view</p>
 * <p>文件名称: BasicView</p>
 * <p>描　　述: [用一句话描述该文件做什么]</p>
 * <p>创建时间: 2020-09-12 23:10</p>
 * <p>公司信息: 福建环宇通信息科技股份公司 研发部</p>
 * @author <a href="mailto:344572231@qq.com">LinShiJing</a>
 * @version v1.0
 * @Copyright: 2020 www.huanyutong.com Inc. All rights reserved.
 * 注意：本内容仅限于福建环宇通信息科技股份公司内部传阅，禁止外泄以及用于其他的商业目的
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * @update [1][2020-09-12] [LinShiJing][变更描述]
 */
public class BasicView extends View {
    private String TAG = this.getClass().getSimpleName();

    public BasicView(Context context) {
        super(context);
    }

    public BasicView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BasicView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BasicView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d(TAG, "View:" + TAG + ":onFinishInflate");
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG, "View:" + TAG + ":onAttachedToWindow:View在可见时(1):View在不可见时(1):View在Gone(加载)时(1)");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "View:" + TAG + ":onMeasure:View在可见时(2):View在不可见时(2)");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d(TAG, "View:" + TAG + ":onSizeChanged:View在可见时(3):View在不可见时(3)");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(TAG, "View:" + TAG + ":onLayout:View在可见时(4):View在不可见时(4)");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "View:" + TAG + ":onDraw:View在可见时(5)");
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        Log.d(TAG, "View:" + TAG + ":onWindowFocusChanged:View被销毁时(1)");
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        Log.d(TAG, "View:" + TAG + ":onWindowVisibilityChanged:View被销毁时(2)");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(TAG, "View:" + TAG + ":onDetachedFromWindow:View被销毁时(3)");
    }
}





















