package com.lijiankun24.shadowlayoutexample.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.lijiankun24.shadowlayoutexample.R;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    private Author mAuthor = new Author();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_github:
                toBrower(mAuthor.getGithub());
                break;
            case R.id.tv_weibo:
                toBrower(mAuthor.getWeibo());
                break;
            case R.id.tv_blog:
                toBrower(mAuthor.getBlog());
                break;
            case R.id.tv_jianshu:
                toBrower(mAuthor.getJianshu());
                break;
            case R.id.tv_mail:
                sendMail(mAuthor.getMail());
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                AboutActivity.this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void initView() {
        TextView tvGithub = (TextView) findViewById(R.id.tv_github);
        tvGithub.setText(Html.fromHtml(getString(R.string.about_github, mAuthor.getGithub())));
        tvGithub.setOnClickListener(this);

        TextView tvWeibo = (TextView) findViewById(R.id.tv_weibo);
        tvWeibo.setText(Html.fromHtml(getString(R.string.about_weibo, mAuthor.getWeibo())));
        tvWeibo.setOnClickListener(this);

        TextView tvBlog = (TextView) findViewById(R.id.tv_blog);
        tvBlog.setText(Html.fromHtml(getString(R.string.about_blog, mAuthor.getBlog())));
        tvBlog.setOnClickListener(this);

        TextView tvJianshu = (TextView) findViewById(R.id.tv_jianshu);
        tvJianshu.setText(Html.fromHtml(getString(R.string.about_jianshu, mAuthor.getJianshu())));
        tvJianshu.setOnClickListener(this);

        TextView tvMail = (TextView) findViewById(R.id.tv_mail);
        tvMail.setText(Html.fromHtml(getString(R.string.about_mail, mAuthor.getMail())));
        tvMail.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        initToolbar(toolbar, true, AboutActivity.this.getString(R.string.about_activity_title));
    }

    private void sendMail(String mailUrl) {
        Intent data = new Intent(Intent.ACTION_SENDTO);
        data.setData(Uri.parse("mailto:" + mailUrl));
        startActivity(data);
    }

    private void toBrower(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    /**
     * 初始化 Toolbar
     *
     * @param toolbar                   要初始化的 Toolbar 对象
     * @param setDisplayHomeAsUpEnabled 是否显示返回键
     * @param title                     标题 Title
     */
    protected void initToolbar(Toolbar toolbar, boolean setDisplayHomeAsUpEnabled, String title) {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(setDisplayHomeAsUpEnabled);
            getSupportActionBar().setTitle(title);
        }
    }
}
