package com.lab.a2.pugman.basearchwithdagger.base;

/*
  Created by pugman on 01.08.17.
  Contact the developer - sckalper@gmail.com
  company - A2Lab

 */

import javax.annotation.ParametersAreNullableByDefault;

/**
 * Class designed as parent for all created Presenter classes in project.
 *
 * @param <T> a view which will be used in current Presenter class. Must be initialized in
 *            constructor
 */
public class BasePresenter<T extends BaseView>{

	/**
	 * Used to call methods in your Activity class
	 */
	@ParametersAreNullableByDefault
	protected T view;
}
