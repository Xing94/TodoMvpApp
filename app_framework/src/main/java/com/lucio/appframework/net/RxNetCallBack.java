package com.lucio.appframework.net;

import com.lucio.appframework.base.BaseView;

import org.reactivestreams.Subscription;

import java.util.Collections;
import java.util.List;

import io.reactivex.FlowableSubscriber;
import retrofit2.Response;

public abstract class RxNetCallBack<T> implements FlowableSubscriber<Response<T>> {

    private static List<Integer> successCodeList = Collections.singletonList(200);

    private BaseView mBaseView;

    public RxNetCallBack(BaseView mBaseView) {
        this.mBaseView = mBaseView;
    }

    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(Response<T> response) {
        if (successCodeList.contains(response.code())) {
            onSuccess(response.body());
        } else {
            Throwable throwable = new Throwable(response.message());
            onError(throwable);
        }
    }

    @Override
    public void onError(Throwable t) {
        mBaseView.showToast(t.getMessage());
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T data);

}
