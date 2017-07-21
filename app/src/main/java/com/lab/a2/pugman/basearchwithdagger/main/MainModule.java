package com.lab.a2.pugman.basearchwithdagger.main;

import dagger.Binds;
import dagger.Module;

/**
 * Created by pugman on 21.07.17.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

@Module
public abstract class MainModule{

	@Binds abstract MainView provideMainView(TestActivity activity);
}
