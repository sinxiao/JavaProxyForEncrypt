package com.xuhj.laosiji.laosiji.present;

import com.xuhj.laosiji.laosiji.MainActivity;
import com.xuhj.laosiji.laosiji.bean.Status;
import com.xuhj.laosiji.laosiji.bean.User;
import com.xuhj.laosiji.laosiji.network.NetWork;

import java.util.List;

import dagger.Module;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xuhj on 2017/6/28.
 */
@Module
public class MainPresent {

	public static interface IMainView {
		public void showuser(User user);
		public void showusers(List<User> users );
		public void delUserSucess(String uid);
	}

	private MainActivity activity;


	IMainView mainView;

	ICommentView commentView;

	public MainPresent(MainActivity activity)
	{
		this.activity = activity;
		mainView = activity;
		commentView = activity;
	}


	public  void saveUser(User user)
	{
		NetWork.provideSsmapi().register(user.getUserName(),user.getUserPhone(),user.getUserEmail(),user.getUserPwd())
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<Status>() {
			@Override
			public void onSubscribe(Disposable d) {

			}

			@Override
			public void onNext(Status status) {
				if(status.getRet()==Status.OK){
					commentView.showMsg("add sucess");
				}else{
					commentView.showMsg("add fail");
				}
			}

			@Override
			public void onError(Throwable e) {
				commentView.showError("fail");
			}

			@Override
			public void onComplete() {

			}
		});
	}

	public void getAllUsers()
	{
		NetWork.provideSsmapi().getAllUser()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<Status>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(Status status) {
						if(status.getRet()==Status.OK){
							mainView.showusers(status.getDatas());
						}else{
							commentView.showError("error empty");
						}
					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onComplete() {

					}
				});
	}

	public void delUser(final String uid)
	{
		NetWork.provideSsmapi().delUser(uid)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<Status>() {
					@Override
					public void onSubscribe(Disposable d) {

					}

					@Override
					public void onNext(Status status) {
						if(status.getRet()==Status.OK){
							commentView.showToast("del sucess");
							mainView.delUserSucess(uid);
						}else{
							commentView.showError("del error");
						}
					}

					@Override
					public void onError(Throwable e) {
						commentView.showError("del fail");
					}

					@Override
					public void onComplete() {

					}
				});
	}

}
