package com.xuhj.laosiji.laosiji.dagger2;

import com.xuhj.laosiji.laosiji.MainActivity;
import com.xuhj.laosiji.laosiji.present.MainPresent;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xuhj on 2017/6/28.
 */
@Module
public class MainModule {

	private MainActivity activity;

	public MainModule(MainActivity activity){
		this.activity = activity;
	}
	@Provides
	public MainPresent provideMainPresent()
	{
		return new MainPresent(activity);
	}



}
