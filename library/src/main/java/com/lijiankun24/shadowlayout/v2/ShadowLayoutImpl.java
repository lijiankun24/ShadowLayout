package com.lijiankun24.shadowlayout.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.Nullable;

/**
 * ShadowLayoutImpl
 * <p>
 * Created by lijiankun24 on 2018/9/25
 * Email: jiankunli24@gmail.com
 */
public interface ShadowLayoutImpl {

    void initialize(ShadowLayoutDelegate shadowLayout, Context context, ColorStateList backgroundColor,
                    float radius, float elevation, float maxElevation);

    void setRadius(ShadowLayoutDelegate shadowLayout, float radius);

    float getRadius(ShadowLayoutDelegate shadowLayout);

    void setElevation(ShadowLayoutDelegate shadowLayout, float elevation);

    float getElevation(ShadowLayoutDelegate shadowLayout);

    void initStatic();

    void setMaxElevation(ShadowLayoutDelegate shadowLayout, float maxElevation);

    float getMaxElevation(ShadowLayoutDelegate shadowLayout);

    float getMinWidth(ShadowLayoutDelegate shadowLayout);

    float getMinHeight(ShadowLayoutDelegate shadowLayout);

    void updatePadding(ShadowLayoutDelegate shadowLayout);

    void onCompatPaddingChanged(ShadowLayoutDelegate shadowLayout);

    void onPreventCornerOverlapChanged(ShadowLayoutDelegate shadowLayout);

    void setBackgroundColor(ShadowLayoutDelegate shadowLayout, @Nullable ColorStateList color);

    ColorStateList getBackgroundColor(ShadowLayoutDelegate shadowLayout);
}
