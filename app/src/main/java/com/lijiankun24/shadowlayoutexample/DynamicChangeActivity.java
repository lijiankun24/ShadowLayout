package com.lijiankun24.shadowlayoutexample;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lijiankun24.shadowlayout.ShadowLayout;

public class DynamicChangeActivity extends AppCompatActivity implements View.OnClickListener {

    private ShadowLayout SlOval = null;

    private ShadowLayout SlRectangle = null;

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
        }
    }

    private void initView() {
        findViewById(R.id.tv_change_oval).setOnClickListener(this);
        findViewById(R.id.tv_change_rectangle).setOnClickListener(this);
        SlOval = findViewById(R.id.sl_oval);
        SlRectangle = findViewById(R.id.sl_rectangle);
    }
}
