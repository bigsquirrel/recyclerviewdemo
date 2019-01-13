package com.xgfe.android.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author zhouxinlin
 * @since 2019/1/12.
 */

public class CustomLayoutManager extends LinearLayoutManager {

    private int[] mMeasuredDimension = new int[2];

    public CustomLayoutManager(Context context) {
        super(context);
    }

    public CustomLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public CustomLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


//    @Override
//    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state,
//                          int widthSpec, int heightSpec) {
//        final int widthMode = View.MeasureSpec.getMode(widthSpec);
//        final int heightMode = View.MeasureSpec.getMode(heightSpec);
//        final int widthSize = View.MeasureSpec.getSize(widthSpec);
//        final int heightSize = View.MeasureSpec.getSize(heightSpec);
//        int width = 0;
//        int height = 0;
//
//        // 测量所有的 item 的高度，如果 item 数量很大会很耗时
//        for (int i = 0; i < getItemCount(); i++) {
//            if (getOrientation() == HORIZONTAL) {
//                measureScrapChild(recycler, i,
//                        View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.UNSPECIFIED),
//                        heightSpec,
//                        mMeasuredDimension);
//
//                width = width + mMeasuredDimension[0];
//                // 取卡片高度的最大值
//                if (mMeasuredDimension[1] > height) {
//                    height = mMeasuredDimension[1];
//                }
//            } else {
//                measureScrapChild(recycler, i,
//                        widthSpec,
//                        View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.UNSPECIFIED),
//                        mMeasuredDimension);
//                height = height + mMeasuredDimension[1];
//                if (i == 0) {
//                    width = mMeasuredDimension[0];
//                }
//            }
//        }
//        switch (widthMode) {
//            case View.MeasureSpec.EXACTLY:
//                width = widthSize;
//                break;
//            case View.MeasureSpec.AT_MOST:
//            case View.MeasureSpec.UNSPECIFIED:
//            default:
//                break;
//        }
//
//        switch (heightMode) {
//            case View.MeasureSpec.EXACTLY:
//                height = heightSize;
//                break;
//            case View.MeasureSpec.AT_MOST:
//            case View.MeasureSpec.UNSPECIFIED:
//            default:
//                break;
//        }
//
//        setMeasuredDimension(width, height);
//    }

    @Override
    public RecyclerView.LayoutParams generateLayoutParams(Context c, AttributeSet attrs) {
        // 计算 item card 的宽度
        int width = c.getResources().getDisplayMetrics().widthPixels;
        return new RecyclerView.LayoutParams((int) (width - DisplayUtil.dp2px(c, 30)),
                ViewGroup.LayoutParams.MATCH_PARENT);
    }

//    @Override
//    public boolean isAutoMeasureEnabled() {
//        // 取消自动测量
//        return false;
//    }

    private void measureScrapChild(RecyclerView.Recycler recycler, int position, int widthSpec,
                                   int heightSpec, int[] measuredDimension) {
        View view = recycler.getViewForPosition(position);
        recycler.bindViewToPosition(view, position);
        if (view != null) {
            RecyclerView.LayoutParams p = (RecyclerView.LayoutParams) view.getLayoutParams();
            int childWidthSpec = ViewGroup.getChildMeasureSpec(widthSpec,
                    getPaddingLeft() + getPaddingRight(), p.width);
            int childHeightSpec = ViewGroup.getChildMeasureSpec(heightSpec,
                    getPaddingTop() + getPaddingBottom(), p.height);

            view.measure(childWidthSpec, childHeightSpec);
            measuredDimension[0] = view.getMeasuredWidth() + p.leftMargin + p.rightMargin;
            measuredDimension[1] = view.getMeasuredHeight() + p.bottomMargin + p.topMargin;
            recycler.recycleView(view);
            Log.e("RVDemo", "measureScrapChild, " + position + ", height: " + view.getMeasuredHeight()
                    + ", view: " + view.hashCode());
        }
    }
}