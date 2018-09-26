package com.lijiankun24.shadowlayout.v2;

import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * ShadowLayoutDelegate
 * <p>
 * Created by lijiankun24 on 2018/9/25
 * Email: jiankunli24@gmail.com
 */
public interface ShadowLayoutDelegate {

    void setShadowBackground(Drawable drawable);

    Drawable getShadowBackground();

    boolean getUseCompatPadding();

    boolean getPreventCornerOverlap();

    void setShadowPadding(int left, int top, int right, int bottom);

    void setMinWidthHeightInternal(int width, int height);

    View getShadowLayout();
}
