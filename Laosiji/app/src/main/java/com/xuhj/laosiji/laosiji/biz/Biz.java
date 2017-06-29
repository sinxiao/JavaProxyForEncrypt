package com.xuhj.laosiji.laosiji.biz;


import com.xuhj.laosiji.laosiji.bean.Status;
import com.xuhj.laosiji.laosiji.bean.User;
import com.xuhj.laosiji.laosiji.network.NetWork;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;



/**
 * Created by xuhj on 2017/4/14.
 */

public class Biz {

	public static void saveUser(User user)
	{
		NetWork.provideSsmapi().register(user.getUserName(),user.getUserPhone(),user.getUserEmail(),user.getUserPwd())
				.subscribeOn(Schedulers.io()).subscribe(new Observer<Status>() {
			@Override
			public void onSubscribe(Disposable d) {

			}

			@Override
			public void onNext(Status status) {

			}

			@Override
			public void onError(Throwable e) {

			}

			@Override
			public void onComplete() {

			}
		});


	}

	public static User getUserById(String uid)
	{
		return  null;
	}

}
