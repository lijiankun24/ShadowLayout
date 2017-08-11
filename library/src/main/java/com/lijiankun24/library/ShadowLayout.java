package com.lijiankun24.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * ShadowLayout.java
 * <p>
 * Created by lijiankun on 17/8/11.
 */

public class ShadowLayout extends RelativeLayout {

    public static final int ALL = 0x10;

    public static final int LEFT = 0x30;

    public static final int TOP = 0x50;

    public static final int RIGHT = 0x03;

    public static final int BOTTOM = 0x05;

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private RectF mRectF = new RectF();

    private int mShadowColor = Color.TRANSPARENT;

    private float mShadowRadius = 0;

    private float mShadowDx = 0;

    private float mShadowDy = 0;

    private int mShadowSide = 0;

    public ShadowLayout(Context context) {
        this(context, null);
    }

    public ShadowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShadowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        float effect = mShadowRadius + dip2px(5);
        float rectLeft = effect;
        float rectTop = effect;
        float rectRight = this.getWidth() - effect;
        float rectBottom = this.getHeight() - effect;
        if (mShadowDy != 0.0f) {
            rectRight = rectRight - (int) dip2px(1);
        }
        if (mShadowDx != 0.0f) {
            rectRight = rectRight - (int) dip2px(1);
        }
        mRectF.left = rectLeft;
        mRectF.top = rectTop;
        mRectF.right = rectRight;
        mRectF.bottom = rectBottom;

        int paddingLeft = (int) effect;
        int paddingTop = (int) effect;
        int paddingRight = (int) effect;
        int paddingBottom = (int) effect;
        if (mShadowDy != 0.0f) {
            paddingBottom = paddingBottom + (int) dip2px(1);
        }
        if (mShadowDx != 0.0f) {
            paddingRight = paddingRight + (int) dip2px(1);
        }
        int leftTmpe = LEFT;
        int topTmpe = TOP;
        int rightTmpe = RIGHT;
        int bottomTmpe = BOTTOM;
        int allTmpe = ALL;
        int bitLeft = mShadowSide & LEFT;
        int bitTop = mShadowSide & TOP;
        int bitRight = mShadowSide & RIGHT;
        int bitBottom = mShadowSide & BOTTOM;
        int bitAll = mShadowSide & ALL;
        this.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(mRectF, mPaint);
    }

    private void init(AttributeSet attrs) {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);  // 关闭硬件加速
        this.setWillNotDraw(false);                    // 调用此方法后，才会执行 onDraw(Canvas) 方法

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ShadowLayout);
        if (typedArray != null) {
            mShadowColor = typedArray.getColor(R.styleable.ShadowLayout_shadowColor,
                    ContextCompat.getColor(getContext(), android.R.color.black));
            mShadowRadius = typedArray.getDimension(R.styleable.ShadowLayout_shadowRadius, dip2px(0));
            mShadowDx = typedArray.getDimension(R.styleable.ShadowLayout_shadowDx, dip2px(0));
            mShadowDy = typedArray.getDimension(R.styleable.ShadowLayout_shadowDy, dip2px(0));
            mShadowSide = typedArray.getInt(R.styleable.ShadowLayout_shadowSide, 0);
            typedArray.recycle();
        }
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.TRANSPARENT);
        mPaint.setShadowLayer(mShadowRadius, mShadowDx, mShadowDy, mShadowColor);
    }

    private float dip2px(float dpValue) {
        DisplayMetrics dm = getContext().getResources().getDisplayMetrics();
        float scale = dm.density;
        return (dpValue * scale + 0.5F);
    }
}
