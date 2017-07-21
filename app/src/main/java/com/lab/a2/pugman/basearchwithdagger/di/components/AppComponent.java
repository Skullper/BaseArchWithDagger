package com.lab.a2.pugman.basearchwithdagger.di.components;

import com.lab.a2.pugman.basearchwithdagger.App;
import com.lab.a2.pugman.basearchwithdagger.di.ModuleBuilder;
import com.lab.a2.pugman.basearchwithdagger.di.modules.AppModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by pugman on 21.07.17.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

@Component(modules = {
		AndroidSupportInjectionModule.class,
		AppModule.class,
		ModuleBuilder.class
})
public interface AppComponent{

	@Component.Builder
	interface Builder {

		@BindsInstance
		Builder application(App application);
		AppComponent build();
	}

	void inject(App app);
}
