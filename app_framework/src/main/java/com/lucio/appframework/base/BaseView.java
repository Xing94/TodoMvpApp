package com.lucio.appframework.base;

import android.support.annotation.StringRes;

/**
 * view的基类
 */
public interface BaseView<T> {

    T initPresenter();

    void showToast(String msg);

    void showToast(@StringRes int msg);

}