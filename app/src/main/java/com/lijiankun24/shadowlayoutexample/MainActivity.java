package com.lijiankun24.shadowlayoutexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.lijiankun24.shadowlayoutexample.about.AboutActivity;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener,
        View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_to_show:
                startActivity(new Intent(MainActivity.this, ShowActivity.class));
                break;
            case R.id.tv_to_dynamic_change:
                startActivity(new Intent(MainActivity.this, DynamicChangeActivity.class));
                break;
        }
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

    private void initView() {
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(this);
        findViewById(R.id.tv_to_show).setOnClickListener(this);
        findViewById(R.id.tv_to_dynamic_change).setOnClickListener(this);
    }
}
