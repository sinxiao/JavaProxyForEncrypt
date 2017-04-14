package com.xuhj.laosiji.laosiji.network;

import com.xuhj.laosiji.laosiji.bean.Result;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by xuhj on 2017/4/12.
 */

public interface LaosijiApi {

	@POST("user/login")
	Observable<Result> login(@Field("phone") String phone, @Field("pwd")String pwd);

	@POST("user/login")
	Observable<Result> loginWithSms(@Field("phone") String phone, @Field("smscode")String smsCode);

	@POST("user/register")
	Observable<Result> register(@Field("phone") String phone, @Field("smscode")String smsCode);

	@POST("user/fetch")
	Observable<Result> fetch(@Field("uid") String uid, @Field("tokenkey")String tokenkey,@Field("diff")String diff);



}
