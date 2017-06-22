package com.xuhj.laosiji.laosiji.dagger2;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by xuhj on 2017/5/2.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
	Context content();
}
