package com.lijiankun24.shadowlayoutexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.lijiankun24.shadowlayout.ShadowLayout;
import com.lijiankun24.shadowlayoutexample.about.AboutActivity;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    private ShadowLayout mShadowLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(this);
        mShadowLayout = findViewById(R.id.shadowLayout1);
        findViewById(R.id.btn_ChangeShadow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShadowLayout.setShadowColor(getResources().getColor(android.R.color.holo_orange_light));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_main_about:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
        }
        return true;
    }
}
