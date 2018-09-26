package com.lijiankun24.shadowlayout.v2;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * RoundRectDrawable
 * <p>
 * Created by lijiankun on 2018/9/26
 * Email: lijiankun03@meituan.com
 */
public class RoundRectDrawable extends Drawable {
    private float mRadius;
    private final Paint mPaint;
    private final RectF mBoundsF;
    private final Rect mBoundsI;

    private ColorStateList mBackground;
    private PorterDuffColorFilter mTintFilter;

    RoundRectDrawable(ColorStateList backgroundColor, float radius) {
        mRadius = radius;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        setBackground(backgroundColor);
        mBoundsF = new RectF();
        mBoundsI = new Rect();
    }

    private void setBackground(ColorStateList color) {
        mBackground = (color == null) ? ColorStateList.valueOf(Color.TRANSPARENT) : color;
        mPaint.setColor(mBackground.getColorForState(getState(), mBackground.getDefaultColor()));
    }

    @Override
    public void draw(Canvas canvas) {
        final Paint paint = mPaint;
        final boolean clearColorFilter;
        if (mTintFilter != null && paint.getColorFilter() == null) {
            paint.setColorFilter(mTintFilter);
            clearColorFilter = true;
        } else {
            clearColorFilter = false;
        }
        canvas.drawRoundRect(mBoundsF, mRadius, mRadius, paint);
        if (clearColorFilter) {
            paint.setColorFilter(null);
        }
    }

    @Override
    public void setAlpha(int i) {
        mPaint.setAlpha(i);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
