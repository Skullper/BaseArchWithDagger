package com.lab.a2.pugman.basearchwithdagger.di;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.lab.a2.pugman.basearchwithdagger.main.MainActivity;
import com.lab.a2.pugman.basearchwithdagger.main.MainSubComponent;
import com.lab.a2.pugman.basearchwithdagger.main.fragments.WelcomeFragment;
import com.lab.a2.pugman.basearchwithdagger.main.fragments.fragment_di.WelcomeFragmentSubComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by pugman on 21.07.17.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

/**
 * Add here your modules
 */
@Module
public abstract class ModuleBuilder{

	@Binds
	@IntoMap
	@ActivityKey(MainActivity.class)
	abstract AndroidInjector.Factory<? extends Activity> bindTestActivityInjectorFactory(MainSubComponent.Builder builder);

	@Binds
	@IntoMap
	@FragmentKey(WelcomeFragment.class)
	abstract AndroidInjector.Factory<? extends Fragment> bindYourFragmentInjectorFactory(WelcomeFragmentSubComponent.Builder builder);
}
