package com.xgfe.android.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouxinlin
 * @since 2018/12/27.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    List<String> taskList = new ArrayList<>();

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new CustomViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bindData(taskList.get(position));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public void setData(List<String> data) {
        this.taskList.clear();
        this.taskList.addAll(data);
        notifyDataSetChanged();
    }

    class CustomViewHolder extends BaseViewHolder {
        TextView textView;

        CustomViewHolder(ViewGroup recyclerView) {
            super(recyclerView, R.layout.adapter_textview);
            textView = itemView.findViewById(R.id.textview);
            itemView.setElevation(DisplayUtil.dp2px(itemView.getContext(), 5));
            itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    Log.e("RVDemo", "itemView onTouch, " + event.toString());

                    return false;
                }
            });
        }

        private void bindData(String str) {
            if (!TextUtils.isEmpty(str)) {
                textView.setText(str);
            }
        }
    }
}
