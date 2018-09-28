package com.lijiankun24.shadowlayout.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.lijiankun24.shadowlayout.R;

/**
 * ShadowLayout
 * <p>
 * Created by lijiankun24 on 2018/9/25
 * Email: jiankunli24@gmail.com
 */
public class ShadowLayout extends FrameLayout {

    private static final int[] COLOR_BACKGROUND_ATTR = {android.R.attr.colorBackground};

    private static final ShadowLayoutImpl IMPL = new ShadowLayoutBaseImpl();

    static {
        IMPL.initStatic();
    }

    final Rect mContentPadding = new Rect();

    final Rect mShadowBounds = new Rect();

    public ShadowLayout(@NonNull Context context) {
        super(context);
        initialize(context, null, 0);
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs, 0);
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs, defStyleAttr);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        // NO OP
    }

    @Override
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        // NO OP
    }

    private void initialize(Context context, AttributeSet attrs, int defStyleAttr) {
        final TypedArray aa = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
        final int themeColorBackground = aa.getColor(0, 0);
        aa.recycle();

        final float[] hsv = new float[3];
        Color.colorToHSV(themeColorBackground, hsv);
        ColorStateList backgroundColor = ColorStateList.valueOf(hsv[2] > 0.5f
                ? getResources().getColor(R.color.shadowlayout_light_background)
                : getResources().getColor(R.color.shadowlayout_dark_background));
        float radius = 10;
        float elevation = 10;
        float maxElevation = 10;
        IMPL.initialize(mShadowLayoutDelegate, context, backgroundColor, radius, elevation, maxElevation);
    }

    private final ShadowLayoutDelegate mShadowLayoutDelegate = new ShadowLayoutDelegate() {
        private Drawable mCardBackground = null;

        @Override
        public void setShadowBackground(Drawable drawable) {
            mCardBackground = drawable;
            if (Build.VERSION.SDK_INT >= 16) {
                setBackground(drawable);
            } else {
                setBackgroundDrawable(drawable);
            }
        }

        @Override
        public Drawable getShadowBackground() {
            return mCardBackground;
        }

        @Override
        public View getShadowLayout() {
            return ShadowLayout.this;
        }

        @Override
        public boolean getUseCompatPadding() {
            return false;
        }

        @Override
        public boolean getPreventCornerOverlap() {
            return false;
        }

        @Override
        public void setShadowPadding(int left, int top, int right, int bottom) {

        }

        @Override
        public void setMinWidthHeightInternal(int width, int height) {

        }
    };
}

