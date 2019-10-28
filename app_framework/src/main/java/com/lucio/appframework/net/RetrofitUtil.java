package com.lucio.appframework.net;

import com.lucio.appframework.AppConstant;
import com.lucio.appframework.util.retrofit.gson.GsonConverterFactory;
import com.lucio.appframework.util.retrofit.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Retrofit工具类
 */
public class RetrofitUtil {

    private static Retrofit retrofit;

    private static OkHttpClient mClient;

    private static String mBaseUrl;

    public static void setBaseUrl(String baseUrl, OkHttpClient okHttpClient) {
        mBaseUrl = baseUrl;
        mClient = okHttpClient;
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(mBaseUrl)
                    .client(mClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static <T> T getService(final Class<T> service) {
        return RetrofitUtil.getInstance().create(service);
    }

    //创建一个新的retrofit对象
    public static Retrofit createRetrofit(String baseUrl) {
        return createRetrofit(baseUrl, mClient);
    }

    //创建一个新的retrofit对象
    public static Retrofit createRetrofit(String baseUrl, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
