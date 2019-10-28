package com.lucio.appframework.util;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.StringRes;
import android.widget.Toast;


/**
 * Toast工具类：单例模式
 */
public class ToastUtil {

    private static Toast mToast;
    private static Context mAppContext;

    public static void initAppContext(Context appContext) {
        mAppContext = appContext;
    }

    public static void show(String msg) {
        if (mAppContext == null) {
            return;
        }
        showToast(mAppContext, msg, Toast.LENGTH_SHORT);
    }

    public static void show(@StringRes int msg) {
        if (mAppContext == null) {
            return;
        }
        showToast(mAppContext, mAppContext.getResources().getString(msg), Toast.LENGTH_SHORT);
    }

    /**
     * 短时间文本提示
     * 避免在子线程中调用时出问题
     *
     * @param activity 上下文
     * @param msg      待提示信息
     */
    public static void showShortToast(final Activity activity, final String msg) {
        activity.runOnUiThread(() -> showToast(activity, msg, Toast.LENGTH_SHORT));
    }

    /**
     * 短时间文本提示
     * 显示在主线程中
     *
     * @param activity 上下文
     * @param msg      待提示信息
     */
    public static void showShortToast(final Activity activity, @StringRes final int msg) {
        activity.runOnUiThread(() -> showToast(activity, activity.getResources().getString(msg), Toast.LENGTH_SHORT));
    }

    /**
     * 短时间文本提示
     *
     * @param context 上下文
     * @param msg     待提示信息
     */
    public static void showLongToast(Context context, String msg) {
        showToast(context, msg, Toast.LENGTH_LONG);
    }

    /**
     * 短时间文本提示
     *
     * @param context 上下文
     * @param msg     待提示信息
     */
    public static void showLongToast(Context context, @StringRes int msg) {
        String toastStr = "";
        try {
            toastStr = context.getResources().getString(msg);
        } catch (Resources.NotFoundException e) {
            toastStr = toastStr + msg;
        }
        showToast(context, toastStr, Toast.LENGTH_LONG);
    }

    /**
     * @param context
     * @param msg
     * @param duration
     */
    public static void showToast(Context context, String msg, int duration) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(context, msg, duration);
        mToast.show();
    }


}
