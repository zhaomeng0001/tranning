package com.xq.caroline.tranning.childActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xq.caroline.tranning.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by caroline on 2017/4/8.
 */

public class TestRecycleViewActivity extends Activity {


    @BindView(R.id.test_recycle_view)
    RecyclerView mRecy;
    TestRecycleAdapter adapter;
    @BindView(R.id.swipe_fresh_layout)
    SwipeRefreshLayout mSwipeFreshLayout;
    @BindView(R.id.title)
    TextView title;
    private List<String> list;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_recycle_view);
        ButterKnife.bind(this);
        initRecycle();
        initSwipeFreshLayout();
        initData();
    }

    private void initData() {
        count = 0;
    }

    private void initSwipeFreshLayout() {
        mSwipeFreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        boolean fromMe = doFreshFromMe();
                        mSwipeFreshLayout.setRefreshing(fromMe);
                        if (mSwipeFreshLayout.isRefreshing()) {
                            mSwipeFreshLayout.setColorSchemeColors(Color.YELLOW, Color.RED, Color.GRAY, Color.GREEN);
                            title.setText("正在刷新");
                        } else {
                            title.setText("没在刷新");
                        }
                    }
                }, 1000);

            }
        });
    }

    private boolean doFreshFromMe() {
        for (int i = count * 10 + 20; i < (count + 1) * 10 + 20; i++) {
            list.add("我是第" + i + "条");
        }
        count++;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.loadData(list);
            }
        });
        return false;
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, TestRecycleViewActivity.class);
        context.startActivity(starter);
    }

    private void initRecycle() {
        mRecy.setLayoutManager(new LinearLayoutManager(this));
        initList();
        adapter = new TestRecycleAdapter(this);
        adapter.loadData(list);
        mRecy.setAdapter(adapter);
    }

    private void initList() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("我是第" + i + "条");
        }
    }

    static class TestRecycleAdapter extends RecyclerView.Adapter<TestRecycleAdapter.MyViewHolder> {

        interface OnMyClickListener {
            void click(int position);
        }

        List<String> strings;

        Context context;

        OnMyClickListener mListener;

        TestRecycleAdapter(Context context) {
            this.context = context;
        }

        public void loadData(List<String> list) {
            this.strings = list;
            notifyDataSetChanged();
        }

        public void addOnMyClickListener(OnMyClickListener listener) {
            this.mListener = listener;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder;
            View view = LayoutInflater.from(context).inflate(R.layout.item_test_recycle_view_num, parent, false);
            holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.mName.setText(strings.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.click(position);
                    }
                }
            });
        }


        @Override
        public int getItemCount() {
            return strings.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.test_recycle_view_item_name)
            TextView mName;

            public MyViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }


    }

}
