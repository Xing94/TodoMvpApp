package com.lucio.mvpapp.data.source.remote;

import com.lucio.mvpapp.constants.UrlConstant;
import com.lucio.mvpapp.data.bean.LoginBean;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Observable：打印String用ResponseBody.string
 * get参数：@Query
 * post参数：@Field
 * header：@Header
 * 可以放实体类:必须继承BaseBean
 * FormUrlEncoded 表单编码，在post请求有多个参数时使用
 */

public interface MainService {

    //restFul写法，需要使用response<T>
    @POST(UrlConstant.login)
    @FormUrlEncoded
    Flowable<Response<LoginBean>> login(@Field("phone") String phone, @Field("loginPwd") String loginPwd);
}
