package com.example.nrecyclerview.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.nrecyclerview.R;
import com.github.nrecyclerview.NPullScrollView;
import com.github.nrecyclerview.dirview.ProgressStyle;
import com.github.nrecyclerview.interfaces.LoadingListener;

public class NPullScrollViewActivity extends AppCompatActivity {

    private NPullScrollView mScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npull_scroll_view);
        initView();
    }

    private void initView() {
        mScrollView = findViewById(R.id.n_scroll_view);
        mScrollView.setLoadingMoreEnabled(true);//启用上拉加载
        mScrollView.setPullRefreshEnabled(false);//禁用下拉刷新
        mScrollView
                .getDefaultRefreshHeaderView()
                .setRefreshTimeVisible(true);
        mScrollView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mScrollView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mScrollView.getDefaultRefreshHeaderView().setRefreshTimeVisible(true);
        mScrollView.getDefaultFootView().setLoadingHint("自定义加载中提示");
        mScrollView.getDefaultFootView().setNoMoreHint("自定义加载完毕提示");
        mScrollView.setLoadingListener(new LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mScrollView.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mScrollView.loadMoreComplete();
                    }
                }, 1000);
            }
        });
        mScrollView.refresh();
    }
}
