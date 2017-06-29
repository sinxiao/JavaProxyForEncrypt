package com.xuhj.laosiji.laosiji.dagger2;

import com.xuhj.laosiji.laosiji.MainActivity;

import dagger.Component;

/**
 * Created by xuhj on 2017/6/28.
 */
@Component(modules = MainModule.class)
public interface MainComponent {
	void inject(MainActivity activity);
}
