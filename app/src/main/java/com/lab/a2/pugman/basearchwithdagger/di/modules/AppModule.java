package com.lab.a2.pugman.basearchwithdagger.di.modules;

import android.content.Context;

import com.lab.a2.pugman.basearchwithdagger.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pugman on 21.07.17.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

@Module
public class AppModule{

	@Singleton
	@Provides
	Context providesApplication(App app){
		return app;
	}

}
