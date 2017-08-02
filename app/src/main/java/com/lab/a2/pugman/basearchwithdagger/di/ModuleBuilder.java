package com.lab.a2.pugman.basearchwithdagger.di;

import com.lab.a2.pugman.basearchwithdagger.main.MainActivity;
import com.lab.a2.pugman.basearchwithdagger.main.MainModule;
import com.lab.a2.pugman.basearchwithdagger.main.fragments.WelcomeFragment;
import com.lab.a2.pugman.basearchwithdagger.main.fragments.fragment_di.WelcomeFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/*
  Created by pugman on 21.07.17.
  Contact the developer - sckalper@gmail.com
  company - A2Lab
 */

/**
 * Add here your modules
 */
@Module
public abstract class ModuleBuilder{

	@ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity bindMainActivity();

	@ContributesAndroidInjector(modules = WelcomeFragmentModule.class)
	abstract WelcomeFragment bindWelcomeFragment();
}
