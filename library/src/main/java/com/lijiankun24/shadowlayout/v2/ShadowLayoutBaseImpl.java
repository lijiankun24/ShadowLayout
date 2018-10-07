package com.lijiankun24.shadowlayout.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
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
    }

    @Override
    public void initialize(ShadowLayoutDelegate shadowLayout, Context context, ColorStateList backgroundColor,
                           final float radius, float elevation, float maxElevation) {
        ShadowDrawable background = createBackground();
        shadowLayout.setShadowBackground(background);
        updatePadding(shadowLayout);
    }

    private ShadowDrawable createBackground() {
        return new ShadowDrawable(Color.RED, 10, 0, 5,
                ShadowDrawable.ALL, ShadowDrawable.SHAPE_RECTANGLE);
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
