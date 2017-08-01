package com.lab.a2.pugman.basearchwithdagger.main;

import android.util.Log;

import com.lab.a2.pugman.basearchwithdagger.api.AppApiService;
import com.lab.a2.pugman.basearchwithdagger.api.UserResponse;
import com.lab.a2.pugman.basearchwithdagger.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pugman on 23.07.17.
 */

public class MainPresenterImpl extends BasePresenter<MainView>{

	@Inject
	AppApiService api;

	@Inject
	public MainPresenterImpl(MainView view){
		this.view = view;
	}

	public void loginUser(String name){
		Call<UserResponse> call = api.getUser(name);
		call.enqueue(new Callback<UserResponse>(){
			@Override
			public void onResponse(Call<UserResponse> call, Response<UserResponse> response){
				switch(response.code()){
					case 200:
						view.loginSuccess();
						break;
					default:
						Log.e("MainPresenterImpl:", "ResponseCode: "+response.code());
						break;
				}
			}

			@Override
			public void onFailure(Call<UserResponse> call, Throwable t){
				Log.e("MainPresenterImpl:", "onFailure: " + t.getMessage());
			}
		});
	}
}
