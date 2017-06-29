package com.xuhj.laosiji.laosiji.network;

import com.xuhj.laosiji.laosiji.bean.Status;
import com.xuhj.laosiji.laosiji.bean.User;

import dagger.Module;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by xuhj on 2017/6/16.
 */
@Module
public interface SSMAPI {
//	@Headers({"Content-Type: application/json","Accept: application/json; charset=utf-8"})//需要添加头


	@POST("/user/addUser")
	Observable<Status> register(@Field("username") String username,@Field("userPhone") String userPhone,
								@Field("userEmail") String userEmail,@Field("pwd") String pwd);

	@GET("/user/getUser/{uid}")
	Observable<User> getUser(@Path("uid") String uid);

	@GET("/user/getalluser")
	Observable<Status> getAllUser();

	@POST("/user/deluser")
	Observable<Status> delUser(@Field("uid") String uid);

}
