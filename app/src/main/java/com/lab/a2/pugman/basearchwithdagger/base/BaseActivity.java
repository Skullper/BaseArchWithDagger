package com.lab.a2.pugman.basearchwithdagger.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by pugman on 24.07.17.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */


public abstract class BaseActivity extends AppCompatActivity implements HasSupportFragmentInjector{

	@Inject
	DispatchingAndroidInjector<Fragment> supportFragmentInjector;

	protected abstract int getLayoutId();

	protected abstract void bindViews();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState){
		AndroidInjection.inject(this);
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());
		bindViews();
	}

	@Override
	public AndroidInjector<Fragment> supportFragmentInjector(){
		return supportFragmentInjector;
	}

}
