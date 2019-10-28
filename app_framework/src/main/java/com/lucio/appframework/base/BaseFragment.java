package com.lucio.appframework.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * fragment基类
 */

public abstract class BaseFragment extends Fragment {

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(onCreateView(), container, false);

            //初始化view
            initView(rootView);

            //初始化数据
            initData();

            //初始化点击事件
            initListener();
        }

        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    /**
     * 设置布局
     */
    public abstract int onCreateView();

    /**
     * 初始化view,工作:主要是用来对view相关操作,比如查找控件等
     */
    public abstract void initView(View contentView);

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 初始化事件监听
     */
    public abstract void initListener();


}
