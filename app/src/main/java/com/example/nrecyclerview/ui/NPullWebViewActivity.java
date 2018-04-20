package com.example.nrecyclerview.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.nrecyclerview.R;
import com.github.nrecyclerview.NPullScrollView;
import com.github.nrecyclerview.dirview.ProgressStyle;
import com.github.nrecyclerview.interfaces.LoadingListener;

public class NPullWebViewActivity extends AppCompatActivity {

    private NPullScrollView mScrollView;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npull_webview);
        initView();
    }

    private void initView() {
        mScrollView = findViewById(R.id.n_scroll_view);
        webView = findViewById(R.id.webview);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());


        mScrollView.getDefaultRefreshHeaderView().setRefreshTimeVisible(true);
        mScrollView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mScrollView.setLoadingListener(new LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        webView.loadUrl("http://www.stay4it.com");
                        mScrollView.refreshComplete();
                    }
                }, 1000);
            }
            @Override
            public void onLoadMore() {
            }
        });
        mScrollView.refresh();
    }
}
