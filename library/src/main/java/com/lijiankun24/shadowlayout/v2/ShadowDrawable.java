package com.lijiankun24.shadowlayout.v2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

/**
 * ShadowDrawable
 * <p>
 * Created by lijiankun on 2018/9/28
 * Email: lijiankun03@meituan.com
 */
public class ShadowDrawable extends Drawable {

    public static final int ALL = 0x1111;

    public static final int LEFT = 0x0001;

    public static final int TOP = 0x0010;

    public static final int RIGHT = 0x0100;

    public static final int BOTTOM = 0x1000;

    public static final int SHAPE_RECTANGLE = 0x0001;

    public static final int SHAPE_OVAL = 0x0010;

    private Paint mPaint;

    private RectF mRectF;

    private boolean mDirty;

    /**
     * 阴影的颜色
     */
    private int mShadowColor = Color.TRANSPARENT;

    /**
     * 阴影的大小范围
     */
    private float mShadowRadius = 0;

    /**
     * 阴影 x 轴的偏移量
     */
    private float mShadowDx = 0;

    /**
     * 阴影 y 轴的偏移量
     */
    private float mShadowDy = 0;

    /**
     * 阴影显示的边界
     */
    private int mShadowSide = ALL;

    /**
     * 阴影的形状，圆形/矩形
     */
    private int mShadowShape = SHAPE_RECTANGLE;

    ShadowDrawable(int shadowColor, float shadowRadius, float shadowDx,
                   float shadowDy, int shadowSide, int shadowShape) {
        this.mShadowColor = shadowColor;
        this.mShadowRadius = shadowRadius;
        this.mShadowDx = shadowDx;
        this.mShadowDy = shadowDy;
        this.mShadowSide = shadowSide;
        this.mShadowShape = shadowShape;

        mPaint = new Paint();
        mPaint.setColor(Color.TRANSPARENT);
        mPaint.setAntiAlias(true);
        mPaint.setShadowLayer(mShadowRadius, mShadowDx, mShadowDy, mShadowColor);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        Log.i("ShadowDrawable", "bounds.left " + bounds.left);
        Log.i("ShadowDrawable", "bounds.top " + bounds.top);
        Log.i("ShadowDrawable", "bounds.right " + bounds.right);
        Log.i("ShadowDrawable", "bounds.bottom " + bounds.bottom);
        mRectF = new RectF(bounds.left - mShadowRadius - mShadowDx,
                bounds.top - mShadowRadius - mShadowDy,
                bounds.right + mShadowRadius - mShadowDx,
                bounds.bottom + mShadowRadius - mShadowDy);
        Log.i("ShadowDrawable", "mRectF.left " + mRectF.left);
        Log.i("ShadowDrawable", "mRectF.top " + mRectF.top);
        Log.i("ShadowDrawable", "mRectF.right " + mRectF.right);
        Log.i("ShadowDrawable", "mRectF.bottom " + mRectF.bottom);
        mDirty = true;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        if (mDirty) {
            Log.i("ShadowDrawable", "draw " + mShadowShape);
            if (mShadowShape == SHAPE_RECTANGLE) {
                canvas.drawRect(mRectF, mPaint);
            } else if (mShadowShape == SHAPE_OVAL) {
                canvas.drawCircle(mRectF.centerX(), mRectF.centerY(), Math.min(mRectF.width(), mRectF.height()) / 2, mPaint);
            }
            mDirty = false;
        }
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
