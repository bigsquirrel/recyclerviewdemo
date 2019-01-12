package com.xgfe.android.recyclerviewdemo;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * @author zhouxinlin
 * @since 2019/1/12.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(ViewGroup recyclerView, @LayoutRes int layout) {
        super(LayoutInflater.from(recyclerView.getContext()).inflate(layout, recyclerView, false));
    }
}