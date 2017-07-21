package com.lab.a2.pugman.basearchwithdagger.di;

import android.app.Activity;

import com.lab.a2.pugman.basearchwithdagger.main.MainSubComponent;
import com.lab.a2.pugman.basearchwithdagger.main.TestActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by pugman on 21.07.17.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

@Module
public abstract class ModuleBuilder{
	@Binds
	@IntoMap
	@ActivityKey(TestActivity.class)
	abstract AndroidInjector.Factory<? extends Activity> bindTestActivityInjectorFactory(MainSubComponent.Builder builder);
}
