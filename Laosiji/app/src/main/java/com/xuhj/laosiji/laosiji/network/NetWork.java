package com.xuhj.laosiji.laosiji.network;

import com.xuhj.laosiji.laosiji.common.Configer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xuhj on 2017/4/12.
 */

public class NetWork {
	private static NetWork netWork;
	private static LaosijiApi laosijiApi;
	private static SSMAPI ssmapi;
	private static OkHttpClient mClient;
	private NetWork(){

	}
	public static NetWork getInstence() {
		if (netWork == null) {
			synchronized (NetWork.class) {
				if (netWork == null) {
					netWork = new NetWork();
				}
			}
		}
		mClient = new OkHttpClient.Builder()
				.addInterceptor(new CustomInterceptor())
				.connectTimeout(5, TimeUnit.SECONDS)
				.readTimeout(10, TimeUnit.SECONDS)
				.build();
		return netWork;
	}

	static class CustomInterceptor implements Interceptor {

		@Override
		public Response intercept(Chain chain) throws IOException {
			Request request = chain.request()
					.newBuilder()
					.header("User-agent", "Mozilla/4.0")
					.build();
			return chain.proceed(request);
		}
	}

	public static LaosijiApi getLaosijiService()
	{
		if(laosijiApi==null){
			Retrofit retrofit = new Retrofit.Builder().client(mClient)
					.baseUrl(Configer.LAOSIJI_UEL)
					.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
					.addConverterFactory(GsonConverterFactory.create())
					.build();
			laosijiApi = retrofit.create(LaosijiApi.class);
		}
		return laosijiApi;
	}

	public static SSMAPI getSsmapi()
	{
		if(ssmapi==null){
			Retrofit retrofit = new Retrofit.Builder().client(mClient)
					.baseUrl(Configer.LAOSIJI_UEL)
					.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
					.addConverterFactory(GsonConverterFactory.create())
					.build();
			ssmapi = retrofit.create(SSMAPI.class);
		}

		return ssmapi;
	}

}
