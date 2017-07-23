package com.lab.a2.pugman.basearchwithdagger.di.modules;

import android.content.Context;

import com.lab.a2.pugman.basearchwithdagger.App;
import com.lab.a2.pugman.basearchwithdagger.main.MainSubComponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pugman on 21.07.17.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

@Module(subcomponents = {MainSubComponent.class})
public class AppModule{

	@Singleton
	@Provides
	Context providesContext(App app){
		return app.getApplicationContext();
	}


}
