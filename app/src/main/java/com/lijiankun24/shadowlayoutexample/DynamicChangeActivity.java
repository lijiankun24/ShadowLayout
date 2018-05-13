package com.lijiankun24.shadowlayoutexample;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.lijiankun24.shadowlayout.ShadowLayout;

public class DynamicChangeActivity extends AppCompatActivity implements View.OnClickListener {

    private ShadowLayout SlOval = null;

    private ShadowLayout SlRectangle = null;

    private ShadowLayout SlRadius = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_change);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_change_oval:
                SlOval.setShadowColor(ContextCompat.getColor(this, R.color.drak_yellow));
                break;
            case R.id.tv_change_rectangle:
                SlRectangle.setShadowColor(Color.parseColor("#EE00FF7F"));
                break;
            case R.id.tv_change_radius:
                SlRadius.setShadowRadius(dip2px(12));
                break;
        }
    }

    private void initView() {
        findViewById(R.id.tv_change_oval).setOnClickListener(this);
        findViewById(R.id.tv_change_rectangle).setOnClickListener(this);
        findViewById(R.id.tv_change_radius).setOnClickListener(this);
        SlOval = findViewById(R.id.sl_oval);
        SlRectangle = findViewById(R.id.sl_rectangle);
        SlRadius = findViewById(R.id.sl_radius);
    }


    /**
     * dip2px dp 值转 px 值
     *
     * @param dpValue dp 值
     * @return px 值
     */
    private float dip2px(float dpValue) {
        DisplayMetrics dm = DynamicChangeActivity.this.getResources().getDisplayMetrics();
        float scale = dm.density;
        return (dpValue * scale + 0.5F);
    }
}
