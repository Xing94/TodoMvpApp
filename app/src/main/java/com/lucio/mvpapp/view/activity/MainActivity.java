package com.lucio.mvpapp.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lucio.appframework.base.BaseActivity;
import com.lucio.appframework.contract.MainContract;
import com.lucio.mvpapp.presenter.MainPresenter;
import com.lucio.mvpapp.R;
import com.lucio.mvpapp.view.adapter.FragmentListAdapter;
import com.lucio.mvpapp.view.fragment.FourFragment;
import com.lucio.mvpapp.view.fragment.OneFragment;
import com.lucio.mvpapp.view.fragment.ThreeFragment;
import com.lucio.mvpapp.view.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements MainContract.View {

    private MainContract.Presenter mPresenter;
    private ViewPager vpContent;

    private RadioGroup rgFragment;
    private RadioButton rbOne;
    private RadioButton rbTwo;
    private RadioButton rbThree;
    private RadioButton rbFour;

    private Toolbar toolbar;

    private List<String> pagerNameList;
    private List<Fragment> fragmentList;


    @Override
    public void onCreate() {
        setContentView(R.layout.activity_main);

        mPresenter = initPresenter();
    }

    @Override
    public void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        vpContent = findViewById(R.id.vp_content);
        rgFragment = findViewById(R.id.rg_fragment);

        rbOne = findViewById(R.id.rb_one);
        rbTwo = findViewById(R.id.rb_two);
        rbThree = findViewById(R.id.rb_three);
        rbFour = findViewById(R.id.rb_four);
    }

    @Override
    public void initData() {
        pagerNameList = new ArrayList<>();
        pagerNameList.add("主页");
        pagerNameList.add("搜索");
        pagerNameList.add("我的");
        pagerNameList.add("设置");

        fragmentList = new ArrayList<>();
        fragmentList.add(OneFragment.newInstance());
        fragmentList.add(TwoFragment.newInstance());
        fragmentList.add(ThreeFragment.newInstance());
        fragmentList.add(FourFragment.newInstance());

        rbOne.setText(pagerNameList.get(0));
        rbOne.setCompoundDrawables(null, mPresenter.getRadioDrawable(getResources().getDrawable(R.drawable.home_selector)), null, null);

        rbTwo.setText(pagerNameList.get(1));
        rbTwo.setCompoundDrawables(null, mPresenter.getRadioDrawable(getResources().getDrawable(R.drawable.search_selector)), null, null);

        rbThree.setText(pagerNameList.get(2));
        rbThree.setCompoundDrawables(null, mPresenter.getRadioDrawable(getResources().getDrawable(R.drawable.account_selector)), null, null);

        rbFour.setText(pagerNameList.get(3));
        rbFour.setCompoundDrawables(null, mPresenter.getRadioDrawable(getResources().getDrawable(R.drawable.set_selector)), null, null);

        FragmentListAdapter mAdapter = new FragmentListAdapter(getSupportFragmentManager(), fragmentList);
        vpContent.setAdapter(mAdapter);

        toolbar.setTitle(pagerNameList.get(0));

        mPresenter.netRequest();
//        设置标题栏左边的图标
//        toolbar.setHomeAsUpIndicator(R.drawable.ic_menu);
//        设置标题栏左边的图标是否显示
//        toolbar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void initListener() {
        rgFragment.setOnCheckedChangeListener((radioGroup, i) -> mPresenter.selectFragment(i));
        vpContent.addOnPageChangeListener(mPresenter.vpChangeListener());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void selectFragment(int position) {
        toolbar.setTitle(pagerNameList.get(position));
        vpContent.setCurrentItem(position);
    }

    @Override
    public void selectRadio(int position) {
        int radioId = R.id.rb_one;
        if (position == 1) radioId = R.id.rb_two;
        else if (position == 2) radioId = R.id.rb_three;
        else if (position == 3) radioId = R.id.rb_four;
        toolbar.setTitle(pagerNameList.get(position));
        rgFragment.check(radioId);
    }

    @Override
    public MainContract.Presenter initPresenter() {
        return new MainPresenter(this);
    }

}
