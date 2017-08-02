package com.lab.a2.pugman.basearchwithdagger.main.fragments.fragment_di;

import com.lab.a2.pugman.basearchwithdagger.main.fragments.WelcomeFragment;
import com.lab.a2.pugman.basearchwithdagger.utils.FragmentHelper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pugman on 23.07.17.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

@Module
abstract public class WelcomeFragmentModule{

	@Provides
	static FragmentHelper providesFragmentHelper(WelcomeFragment fragment){
		return new FragmentHelper(fragment);
	}
}
