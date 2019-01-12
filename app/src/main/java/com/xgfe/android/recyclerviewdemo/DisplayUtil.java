package com.xgfe.android.recyclerviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

/**
 * @author zhouxinlin
 * @since 2019/1/12.
 */

public final class DisplayUtil {
    private final DisplayMetrics displayMetrics;

    /** @deprecated  */
    @Deprecated
    public DisplayUtil(@NonNull Context context) {
        this.displayMetrics = context.getResources().getDisplayMetrics();
    }

    /** @deprecated  */
    @Deprecated
    public DisplayMetrics getDisplayMetrics() {
        return this.displayMetrics;
    }

    /** @deprecated  */
    @Deprecated
    public int px2dip(float pxValue) {
        float scale = this.displayMetrics.density;
        return (int) (pxValue / scale + 0.5F);
    }

    /** @deprecated  */
    @Deprecated
    public int dip2px(float dipValue) {
        float scale = this.displayMetrics.density;
        return (int) (dipValue * scale + 0.5F);
    }

    /** @deprecated  */
    @Deprecated
    public float dp2px(int dp) {
        return this.displayMetrics.density * (float) dp;
    }

    /** @deprecated  */
    @Deprecated
    public int px2sp(float pxValue) {
        float fontScale = this.displayMetrics.scaledDensity;
        return (int) (pxValue / fontScale + 0.5F);
    }

    /** @deprecated  */
    @Deprecated
    public int sp2px(float spValue) {
        float fontScale = this.displayMetrics.scaledDensity;
        return (int) (spValue * fontScale + 0.5F);
    }

    /** @deprecated  */
    @Deprecated
    public int screenWidthPx() {
        return this.displayMetrics.widthPixels;
    }

    /** @deprecated  */
    @Deprecated
    public int screenHeightPx() {
        return this.displayMetrics.heightPixels;
    }

    public static int px2dip(@NonNull Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5F);
    }

    public static int dip2px(@NonNull Context context, float dipValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5F);
    }

    public static float dp2px(@NonNull Context context, int dp) {
        return context.getResources().getDisplayMetrics().density * (float) dp;
    }

    public static int px2sp(@NonNull Context context, float pxValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5F);
    }

    public static int sp2px(@NonNull Context context, float spValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5F);
    }

    public static int screenWidthPx(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int screenHeightPx(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}
