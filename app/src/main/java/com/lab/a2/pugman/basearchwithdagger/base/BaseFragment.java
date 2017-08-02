package com.lab.a2.pugman.basearchwithdagger.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.annotation.ParametersAreNullableByDefault;

import dagger.android.support.AndroidSupportInjection;

/*
  Created by pugman on 24.07.17.
  Contact the developer - sckalper@gmail.com
  company - A2Lab
 */

/**
 * Class designed as parent for all Fragments created in project.
 *
 * @param <T> activity which creates a fragment. Should be initialized in bindActivity() method
 */
public abstract class BaseFragment<T extends BaseActivity> extends Fragment{

	@ParametersAreNullableByDefault
	protected T activity;

	/**
	 * This method used for initializing the {@link #activity} object
	 *
	 * @return activity instance. Should be used instead of {@link #getActivity()}
	 */
	protected abstract T bindActivity();

	/**
	 * @return resourceId of layout which designed for current fragment
	 */
	protected abstract int getLayoutId();

	/**
	 * Initialize all views here(e.g. ButterKnife.bind(this, rootView)).
	 * This method do the same as onViewCreated()
	 *
	 * @param rootView already inflated view
	 */
	protected abstract void bindViews(View rootView);

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
		return inflater.inflate(getLayoutId(), container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
		super.onViewCreated(view, savedInstanceState);
		bindViews(view);
	}

}
