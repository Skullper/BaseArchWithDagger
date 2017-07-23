package com.lab.a2.pugman.basearchwithdagger.main.fragments.fragment_di;

import com.lab.a2.pugman.basearchwithdagger.main.fragments.WelcomeFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by pugman on 23.07.17.
 */

@Subcomponent(modules = WelcomeFragmentModule.class)
public interface WelcomeFragmentSubComponent extends AndroidInjector<WelcomeFragment>{

	@Subcomponent.Builder
	abstract class Builder extends AndroidInjector.Builder<WelcomeFragment> {
	}
}
