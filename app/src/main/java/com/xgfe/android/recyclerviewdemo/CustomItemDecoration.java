package com.xgfe.android.recyclerviewdemo;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.util.Log;
import android.view.View;

/**
 * @author zhouxinlin
 * @since 2018/12/27.
 */

public class CustomItemDecoration extends ItemDecoration {
    private int space;
    private int marginParentLeft;
    private int marginParentRight;
    private int marginParentBottom;
    private int marginParentTop;

    /**
     * @param space              item 间的间距, dp
     * @param marginParentLeft   卡片与 parent 左侧间距, dp
     * @param marginParentRight  卡片与 parent 右侧间距, dp
     * @param marginParentBottom 卡片与 parent 底部间距, dp
     * @param marginParentTop    卡片与 parent 顶部间距, dp
     */
    public CustomItemDecoration(int space,
                                int marginParentLeft,
                                int marginParentRight,
                                int marginParentBottom,
                                int marginParentTop) {
        this.space = space;
        this.marginParentLeft = marginParentLeft;
        this.marginParentRight = marginParentRight;
        this.marginParentBottom = marginParentBottom;
        this.marginParentTop = marginParentTop;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int spacePx = (int) DisplayUtil.dp2px(view.getContext(), space);
        outRect.left = spacePx >> 1;
        outRect.right = spacePx >> 1;

        int marginTop = (int) DisplayUtil.dp2px(view.getContext(), marginParentTop);
        outRect.bottom = (int) DisplayUtil.dp2px(view.getContext(), marginParentBottom);

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left = (int) DisplayUtil.dp2px(view.getContext(), marginParentLeft);
        } else if (parent.getChildAdapterPosition(view) == getItemCount(parent) - 1) {
            outRect.right = (int) DisplayUtil.dp2px(view.getContext(), marginParentRight);
        }
        // 设定卡片距离顶端的间距
        outRect.top = parent.getHeight() - view.getMeasuredHeight() - marginTop - outRect.bottom;

        Log.e("RVDemo", "getItemOffsets, view: " + view.hashCode() + ", height: " + view.getMeasuredHeight()
                + ", parent: " + parent.getHeight());
    }

    private int getItemCount(RecyclerView parent) {
        final RecyclerView.Adapter a = parent != null ? parent.getAdapter() : null;
        return a != null ? a.getItemCount() : 0;
    }
}
