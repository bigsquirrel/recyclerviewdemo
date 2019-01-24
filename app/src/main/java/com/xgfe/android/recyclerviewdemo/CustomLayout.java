package com.xgfe.android.recyclerviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import com.amap.api.maps2d.MapView;

/**
 * Created by ivanchou on 2019/1/13.
 */

public class CustomLayout extends RelativeLayout {
    public CustomLayout(Context context) {
        super(context);
    }

    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("RVDemo", "CustomLayout dispatchTouchEvent, " + ev.toString());

        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("RVDemo", "CustomLayout onTouchEvent, " + event.toString());
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof MapView) {
                MapView mapView = (MapView) getChildAt(i);
                return mapView.dispatchTouchEvent(event);
            }
        }
        return super.onTouchEvent(event);
    }
}
