package com.lijiankun24.shadowlayoutexample.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lijiankun24.shadowlayoutexample.R;

import java.util.List;

/**
 * TestAdapter
 * <p>
 * Created by lijiankun on 2018/10/11
 * Email: lijiankun03@meituan.com
 */
class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    private List<String> mDataList;

    private Context mContext;

    TestAdapter(List<String> dataList, Context context) {
        this.mDataList = dataList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_list_item,
                viewGroup, false);
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder testViewHolder, int i) {
        String msg = null;
        if (i >= 0 && i < mDataList.size()) {
            msg = mDataList.get(i);
        }
        testViewHolder.onBind(msg);
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    static class TestViewHolder extends RecyclerView.ViewHolder {

        private TextView mTV;

        TestViewHolder(@NonNull View itemView) {
            super(itemView);
            mTV = itemView.findViewById(R.id.tv_item);
        }

        void onBind(String msg) {
            mTV.setText(msg);
        }
    }
}
