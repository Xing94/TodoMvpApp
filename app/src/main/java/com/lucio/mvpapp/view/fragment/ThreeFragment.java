package com.lucio.mvpapp.view.fragment;

import android.os.Bundle;
import android.view.View;

import com.lucio.appframework.base.BaseFragment;
import com.lucio.mvpapp.R;

public class ThreeFragment extends BaseFragment {


    public static ThreeFragment newInstance() {
        ThreeFragment fragment = new ThreeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int onCreateView() {
        return R.layout.fragment_three;
    }

    @Override
    public void initView(View contentView) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

}
