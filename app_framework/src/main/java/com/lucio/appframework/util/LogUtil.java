package com.lucio.appframework.util;

import android.util.Log;

import com.lucio.appframework.AppConstant;

/**
 * 日志工具类
 */
public class LogUtil {

    /**
     * @param tag 日志tag
     * @param msg 待打印信息
     */
    public static void d(String tag, String msg) {
        if (AppConstant.isDebug && msg != null) {
            Log.d(tag, msg);
        }
    }

    /**
     * error日志打印
     *
     * @param tag 日志tag
     * @param msg 待打印信息
     */
    public static void e(String tag, String msg) {
        if (AppConstant.isDebug && msg != null) {
            Log.e(tag, msg);
        }
    }

    /**
     * error日志打印
     *
     * @param e 待打印信息
     */
    public static void e(Throwable e) {
        if (AppConstant.isDebug && e != null) {
            e.printStackTrace();
        }
    }

    /**
     * info日志打印
     *
     * @param tag 日志tag
     * @param msg 待打印信息
     */
    public static void i(String tag, String msg) {
        if (AppConstant.isDebug && msg != null) {
            Log.i(tag, msg);
        }
    }

    /**
     * verbose日志打印
     *
     * @param tag 日志tag
     * @param msg 待打印信息
     */
    public static void v(String tag, String msg) {
        if (AppConstant.isDebug && msg != null) {
            Log.v(tag, msg);
        }
    }

    /**
     * warn日志打印
     *
     * @param tag 日志tag
     * @param msg 待打印信息
     */
    public static void w(String tag, String msg) {
        if (AppConstant.isDebug && msg != null) {
            Log.w(tag, msg);
        }
    }

    /**
     * System.out.println打印日志
     *
     * @param msg
     */
    public static void out(String msg) {
        if (AppConstant.isDebug && msg != null) {
            System.out.println(msg);
        }
    }
}
