package com.xuhj.laosiji.laosiji.dagger2;

import dagger.Component;

/**
 * Created by xuhj on 2017/5/2.
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
}
