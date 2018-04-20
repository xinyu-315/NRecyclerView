package com.example.nrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nrecyclerview.R;
import com.example.nrecyclerview.interfaces.ItemClickListener;

import java.util.ArrayList;

/**
 * Created by niuxinyu on 2018/4/17 0017.
 */

public class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.ViewHolder>{

    public ArrayList<String> mDataList = null;
    private ItemClickListener mClicklistener;

    //构造函数获取上下文对象，及数据
    public BaseAdapter(Context context,ArrayList<String> dataList) {
        this.mDataList=dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTextView.setText(mDataList.get(position));
        holder.mTextView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mClicklistener != null){
                            mClicklistener.onItemClick(position);
                        }
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView =itemView.findViewById(R.id.text);
        }
    }


    /**
     * 设置点击事件
     * @param clicklistener
     */
    public void setClicklistener(ItemClickListener clicklistener) {
        this.mClicklistener = clicklistener;
    }
}
