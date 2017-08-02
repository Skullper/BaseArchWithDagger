package com.lab.a2.pugman.basearchwithdagger.main;

import com.lab.a2.pugman.basearchwithdagger.utils.FragmentHelper;

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
	static FragmentHelper providesFragmentHelper(MainActivity activity){
		return new FragmentHelper(activity);
	}
}
