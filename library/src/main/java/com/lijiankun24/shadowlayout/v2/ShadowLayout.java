package com.lijiankun24.shadowlayout.v2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

/**
 * ShadowLayout
 * <p>
 * Created by lijiankun24 on 2018/9/25
 * Email: jiankunli24@gmail.com
 */
public class ShadowLayout extends FrameLayout {

    private ShadowDrawable drawable;

    public ShadowLayout(@NonNull Context context) {
        this(context, null, 0);
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {
        drawable = new ShadowDrawable.Builder()
                .setBgColor(Color.parseColor("#3D5AFE"))
                .setShapeRadius(dpToPx(8))
                .setShadowColor(Color.parseColor("#66ff0000"))
                .setShadowRadius(dpToPx(10))
                .setOffsetX(0)
                .setOffsetY(0)
                .builder();
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);      // 关闭硬件加速
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.i("ShadowLayout", "ShadowLayout onMeasure");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        switch (widthMode) {
            case MeasureSpec.EXACTLY:
            case MeasureSpec.AT_MOST:
                widthMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(widthMeasureSpec) + dpToPx(10), widthMode);
                break;
        }

        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        switch (heightMode) {
            case MeasureSpec.EXACTLY:
            case MeasureSpec.AT_MOST:
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(widthMeasureSpec) + dpToPx(10), heightMode);
                break;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        Log.i("ShadowLayout", "ShadowLayout dispatchDraw");
        super.dispatchDraw(canvas);
        ViewCompat.setBackground(ShadowLayout.this, drawable);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        // NO OP
    }

    @Override
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        // NO OP
    }

    private int dpToPx(int dp) {
        return (int) (Resources.getSystem().getDisplayMetrics().density * dp + 0.5f);
    }
}

