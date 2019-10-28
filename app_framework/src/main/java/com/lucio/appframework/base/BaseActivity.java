package com.lucio.appframework.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.lucio.appframework.R;
import com.lucio.appframework.util.ToastUtil;


/**
 * activity基类
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        onCreate();

        initView();
        initData();
        initListener();
    }

    //做setContentView等操作
    public abstract void onCreate();

    //初始化视图
    public abstract void initView();

    //初始化数据
    public abstract void initData();

    //初始化事件监听
    public abstract void initListener();

    //获取ActionBar：不设置的话默认显示的是activity的label
//    public ActionBar getBar() {
//        return mActionBar;
//    }

    public void showToast(String msg) {
        ToastUtil.showShortToast(this, msg);
    }

    public void showToast(@StringRes int msg) {
        ToastUtil.showShortToast(this, msg);
    }

    /**
     * 初始化状态栏高度设置
     * 暂时不使用
     */
    private void initStatusBar() {
        // 判断当前系统版本号是否大于4.4,如果小于,则不继续进行
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) return;

        // 设置透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        // 由于4.4-5.5和5.0以上两个版本的透明状态栏有不同的设置方法,因此需要进行不同版本的适配
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            ViewGroup contentView = (ViewGroup) findViewById(android.R.id.content);
            View statusBarView = new View(this);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    getStatusBarHeight(this));
            statusBarView.setBackgroundColor(Color.TRANSPARENT);
            contentView.addView(statusBarView, lp);
        }

        // 系统版本大于5.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    /**
     * 获取状态栏高度
     *
     * @param context 上下文
     * @return 状态栏高度
     */
    public int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
