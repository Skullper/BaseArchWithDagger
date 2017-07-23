package com.lab.a2.pugman.basearchwithdagger.main;

import android.support.v4.app.FragmentManager;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by pugman on 21.07.17.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

@Module
public abstract class MainModule{

	@Binds
	abstract MainView provideMainView(MainActivity activity);

	@Provides
	static FragmentManager providesFragmentManager(MainActivity activity){
		return activity.getSupportFragmentManager();
	}

}
