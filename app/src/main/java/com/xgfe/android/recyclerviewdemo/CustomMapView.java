package com.xgfe.android.recyclerviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import com.amap.api.maps2d.MapView;

/**
 * Created by ivanchou on 2019/1/24.
 */

public class CustomMapView extends MapView {
    public CustomMapView(Context context) {
        super(context);
    }

    public CustomMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("RVDemo", "CustomMapView dispatchTouchEvent, " + ev.toString());

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("RVDemo", "CustomMapView onInterceptTouchEvent, " + ev.toString());

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("RVDemo", "CustomMapView onTouchEvent, " + event.toString());

        return super.onTouchEvent(event);
    }
}
