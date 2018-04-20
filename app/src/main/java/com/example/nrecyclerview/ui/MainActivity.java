package com.example.nrecyclerview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.nrecyclerview.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void gotoNRecyclerViewActivity(View v){
        Intent intent = new Intent();
        intent.setClass(this,NRecyclerViewActivity.class);
        startActivity(intent);
    }
    public void gotoNPullWebViewActivity(View v){
        Intent intent = new Intent();
        intent.setClass(this,NPullWebViewActivity.class);
        startActivity(intent);
    }
    public void gotoNPullScrollViewActivity(View v){
        Intent intent = new Intent();
        intent.setClass(this, NPullScrollViewActivity.class);
        startActivity(intent);
    }
}
