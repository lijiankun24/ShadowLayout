package com.lijiankun24.shadowlayout.v2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * ShadowHelper
 * <p>
 * Created by lijiankun on 2018/9/28
 * Email: lijiankun03@meituan.com
 */
public interface ShadowHelper {
    void drawRoundRect(Canvas canvas, RectF bounds, float cornerRadius, Paint paint);
}
