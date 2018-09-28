package com.lijiankun24.shadowlayout.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;

/**
 * ShadowLayoutBaseImpl
 * <p>
 * Created by lijiankun on 2018/9/28
 * Email: lijiankun03@meituan.com
 */
public class ShadowLayoutBaseImpl implements ShadowLayoutImpl {

    private final RectF mCornerRect = new RectF();

    @Override
    public void initStatic() {
        ShadowDrawable.sRoundRectHelper = new ShadowHelper() {
            @Override
            public void drawRoundRect(Canvas canvas, RectF bounds, float cornerRadius, Paint paint) {
                final float twoRadius = cornerRadius * 2;
                final float innerWidth = bounds.width() - twoRadius - 1;
                final float innerHeight = bounds.height() - twoRadius - 1;
                if (cornerRadius >= 1f) {
                    float roundCornerRadius = cornerRadius + .5f;
                    mCornerRect.set(-roundCornerRadius, -roundCornerRadius, roundCornerRadius, roundCornerRadius);
                    int saved = canvas.save();
                    // Left & Top
                    canvas.translate(bounds.left + roundCornerRadius, bounds.top + roundCornerRadius);
                    canvas.drawArc(mCornerRect, 180, 90, true, paint);
                    // Right & Top
                    canvas.translate(innerWidth, 0);
                    canvas.rotate(90);
                    canvas.drawArc(mCornerRect, 180, 90, true, paint);
                    // Right & Bottom
                    canvas.translate(0, innerHeight);
                    canvas.rotate(90);
                    canvas.drawArc(mCornerRect, 180, 90, true, paint);
                    // Left & Bottom
                    canvas.translate(innerWidth, 0);
                    canvas.rotate(90);
                    canvas.drawArc(mCornerRect, 180, 90, true, paint);

                    canvas.restoreToCount(saved);

                    canvas.drawRect(bounds.left + roundCornerRadius - 1f, bounds.top,
                            bounds.right - roundCornerRadius + 1f,
                            bounds.top + roundCornerRadius, paint);

                    canvas.drawRect(bounds.left + roundCornerRadius - 1f,
                            bounds.bottom - roundCornerRadius,
                            bounds.right - roundCornerRadius + 1f, bounds.bottom, paint);
                }
                // center
                canvas.drawRect(bounds.left, bounds.top + cornerRadius,
                        bounds.right, bounds.bottom - cornerRadius, paint);
            }
        };
    }

    @Override
    public void initialize(ShadowLayoutDelegate shadowLayout, Context context, ColorStateList backgroundColor,
                           final float radius, float elevation, float maxElevation) {
        ShadowDrawable background = createBackground(context, backgroundColor, radius, elevation, maxElevation);
        background.setAddPaddingForCorners(shadowLayout.getPreventCornerOverlap());
        shadowLayout.setShadowBackground(background);
        updatePadding(shadowLayout);
    }

    private ShadowDrawable createBackground(Context context, ColorStateList backgroundColor, float radius,
                                            float elevation, float maxElevation) {
        return new ShadowDrawable(context.getResources(), backgroundColor, radius, elevation, maxElevation);
    }

    @Override
    public void updatePadding(ShadowLayoutDelegate shadowLayout) {

    }

    @Override
    public void setRadius(ShadowLayoutDelegate shadowLayout, float radius) {

    }

    @Override
    public float getRadius(ShadowLayoutDelegate shadowLayout) {
        return 0;
    }

    @Override
    public void setElevation(ShadowLayoutDelegate shadowLayout, float elevation) {

    }

    @Override
    public float getElevation(ShadowLayoutDelegate shadowLayout) {
        return 0;
    }

    @Override
    public void setMaxElevation(ShadowLayoutDelegate shadowLayout, float maxElevation) {

    }

    @Override
    public float getMaxElevation(ShadowLayoutDelegate shadowLayout) {
        return 0;
    }

    @Override
    public float getMinWidth(ShadowLayoutDelegate shadowLayout) {
        return 0;
    }

    @Override
    public float getMinHeight(ShadowLayoutDelegate shadowLayout) {
        return 0;
    }

    @Override
    public void onCompatPaddingChanged(ShadowLayoutDelegate shadowLayout) {

    }

    @Override
    public void onPreventCornerOverlapChanged(ShadowLayoutDelegate shadowLayout) {

    }

    @Override
    public void setBackgroundColor(ShadowLayoutDelegate shadowLayout, @Nullable ColorStateList color) {

    }

    @Override
    public ColorStateList getBackgroundColor(ShadowLayoutDelegate shadowLayout) {
        return null;
    }
}
