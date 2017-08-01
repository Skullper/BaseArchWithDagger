package com.lab.a2.pugman.basearchwithdagger.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by pugman on 24.07.17.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */


public abstract class BaseFragment<T extends BaseActivity> extends Fragment{

	protected T activity;

	protected abstract T bindActivity();

	protected abstract int getLayout();

	protected abstract void findViews(View rootView);

	@Override
	public void onAttach(Context context){
		AndroidSupportInjection.inject(this);
		super.onAttach(context);
		activity = bindActivity();
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
		return inflater.inflate(getLayout(), container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
		super.onViewCreated(view, savedInstanceState);
		findViews(view);
	}

}
