package com.lab.a2.pugman.basearchwithdagger.main;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by pugman on 21.07.17.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

@Subcomponent(modules = {MainModule.class})
public interface MainSubComponent extends AndroidInjector<TestActivity>{

	@Subcomponent.Builder
	abstract class Builder extends AndroidInjector.Builder<TestActivity>{
	}
}
