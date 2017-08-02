package com.lab.a2.pugman.basearchwithdagger.utils;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.lab.a2.pugman.basearchwithdagger.base.BaseActivity;
import com.lab.a2.pugman.basearchwithdagger.base.BaseFragment;

/*
  Created by pugman on 02.08.17.
  Contact the developer - sckalper@gmail.com
  company - A2Lab
 */

/**
 * Designed for more convenient communication with fragments
 */
public class FragmentHelper{

	private BaseActivity mActivity;
	private int          mContainerId;

	public FragmentHelper(BaseActivity activity){
		this.mActivity = activity;
	}

	public FragmentHelper(BaseFragment fragment){
		this.mActivity = (BaseActivity) fragment.getActivity();
	}

	public void replace(BaseFragment fragment, @IdRes int containerId){
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.addToBackStack(getStackTag()).replace(containerId, fragment, fragment.getClass().getSimpleName()).commitAllowingStateLoss();
	}

	/**
	 * Use this only if you directly initialized {@link #mContainerId}
	 * @param fragment which should be replaced
	 */
	public void replace(BaseFragment fragment){
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.addToBackStack(getStackTag()).replace(mContainerId, fragment, fragment.getClass().getSimpleName()).commitAllowingStateLoss();
	}

	public void replaceWithoutBackStack(BaseFragment fragment, @IdRes int containerId){
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.replace(containerId, fragment, fragment.getClass().getSimpleName()).commitAllowingStateLoss();
	}

	/**
	 * Use this only if you directly initialized {@link #mContainerId}
	 * @param fragment which should be replaced
	 */
	public void replaceWithoutBackStack(BaseFragment fragment){
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.replace(mContainerId, fragment, fragment.getClass().getSimpleName()).commitAllowingStateLoss();
	}

	public void add(BaseFragment fragment, @IdRes int containerId){
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.addToBackStack(getStackTag()).add(containerId, fragment, fragment.getClass().getSimpleName()).commitAllowingStateLoss();
	}

	/**
	 * Use this only if you directly initialized {@link #mContainerId}
	 * @param fragment which should be added above
	 */
	public void add(BaseFragment fragment){
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.addToBackStack(getStackTag()).add(mContainerId, fragment, fragment.getClass().getSimpleName()).commitAllowingStateLoss();
	}

	public void addWithoutBackStack(BaseFragment fragment, @IdRes int containerId){
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.add(containerId, fragment, fragment.getClass().getSimpleName()).commitAllowingStateLoss();
	}

	/**
	 * Use this only if you directly initialized {@link #mContainerId}
	 * @param fragment which should be added above
	 */
	public void addWithoutBackStack(BaseFragment fragment){
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.add(mContainerId, fragment, fragment.getClass().getSimpleName()).commitAllowingStateLoss();
	}

	public FragmentManager getFragmentManager(){
		return mActivity.getSupportFragmentManager();
	}

	public boolean isCanGoBack(){
		return getFragmentManager().getBackStackEntryCount() > 1;
	}

	/**
	 * Go back to previous fragment in stack
	 */
	public void back(){
		if(isCanGoBack()) {
			getFragmentManager().popBackStack();
		} else{
			mActivity.finish();
		}
	}

	/**
	 * Removes all fragments in stack and go back to current activity
	 */
	public void clear(){
		getFragmentManager().popBackStack(getStackTag(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
	}

	private String getStackTag(){
		return mActivity.getClass().getSimpleName();
	}
}
