package com.lucio.mvpapp.presenter;


import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;

import com.lucio.appframework.contract.MainContract;
import com.lucio.mvpapp.data.bean.LoginBean;
import com.lucio.mvpapp.data.source.remote.MainService;
import com.lucio.appframework.net.RetrofitUtil;
import com.lucio.appframework.net.RxNetCallBack;
import com.lucio.appframework.util.LogUtil;
import com.lucio.mvpapp.R;

import org.reactivestreams.Subscription;

import io.reactivex.FlowableSubscriber;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import retrofit2.Response;

/**
 * 主页面
 * 为什么不用tabHost：tabHost每一次切换都是replace，影响加载速度
 */
public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void start() {

    }

    @Override
    public void netRequest() {

        RetrofitUtil.getService(MainService.class).login("","")
                .observeOn(Schedulers.newThread())
                .subscribe(new RxNetCallBack<LoginBean>(mView) {
                    @Override
                    public void onSuccess(LoginBean data) {

                    }
                });

    }

    @Override
    public void selectFragment(int radioId) {
        switch (radioId) {
            case R.id.rb_one:
                mView.selectFragment(0);
                break;
            case R.id.rb_two:
                mView.selectFragment(1);
                break;
            case R.id.rb_three:
                mView.selectFragment(2);
                break;
            case R.id.rb_four:
                mView.selectFragment(3);
                break;
        }
    }

    @Override
    public Drawable getRadioDrawable(Drawable drawable) {
        drawable.setBounds(0, 0, 50, 50);
        return drawable;
    }

    @Override
    public ViewPager.OnPageChangeListener vpChangeListener() {
        return new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mView.selectRadio(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }

    //子线程的视图操作
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 101:
                    break;
            }
        }
    };
}
