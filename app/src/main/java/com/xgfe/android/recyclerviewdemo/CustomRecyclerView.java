package com.xgfe.android.recyclerviewdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by ivanchou on 2019/1/13.
 */

public class CustomRecyclerView extends RecyclerView {
    public CustomRecyclerView(Context context) {
        super(context);
    }

    public CustomRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("RVDemo", "CustomRecyclerView dispatchTouchEvent, " + ev.toString());

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        Log.e("RVDemo", "CustomRecyclerView onInterceptTouchEvent, " + e.toString());

        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        Log.e("RVDemo", "CustomRecyclerView onTouchEvent, " + e.toString());

        return super.onTouchEvent(e);
    }


}
