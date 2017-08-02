package com.lab.a2.pugman.basearchwithdagger.main.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lab.a2.pugman.basearchwithdagger.R;
import com.lab.a2.pugman.basearchwithdagger.api.AppApiService;
import com.lab.a2.pugman.basearchwithdagger.api.UserResponse;
import com.lab.a2.pugman.basearchwithdagger.base.BaseFragment;
import com.lab.a2.pugman.basearchwithdagger.main.MainActivity;
import com.lab.a2.pugman.basearchwithdagger.utils.FragmentHelper;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pugman on 23.07.17.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

public class WelcomeFragment extends BaseFragment<MainActivity>{

	public static final String EXTRA_USER_NAME = "user.name";

	@Inject
	AppApiService appApiService;

	@Inject
	FragmentHelper fragmentHelper;

	public static WelcomeFragment newInstance(String name){
		Bundle args = new Bundle();
		args.putString(EXTRA_USER_NAME, name);
		WelcomeFragment fragment = new WelcomeFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	protected MainActivity bindActivity(){
		return (MainActivity) getActivity();
	}

	@Override
	protected int getLayoutId(){
		return R.layout.fragment_welcome;
	}

	@Override
	protected void bindViews(View rootView){
		String userName = getArguments().getString(EXTRA_USER_NAME, "Empty");
		final TextView welcomeText = (TextView) rootView.findViewById(R.id.welcomeTv);
		welcomeText.setText(userName);
		welcomeText.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				if(welcomeText.getText().toString().contentEquals("New Welcome Frag")){
					fragmentHelper.back();
				} else{
					fragmentHelper.add(WelcomeFragment.newInstance("New Welcome Frag"), R.id.container);
				}
			}
		});
		appApiService.getUser(userName).enqueue(new Callback<UserResponse>(){
			@Override
			public void onResponse(Call<UserResponse> call, Response<UserResponse> response){
				switch(response.code()){
					case 200:
						Toast.makeText(activity.getApplicationContext(), "Restart", Toast.LENGTH_LONG).show();
						break;
					default:
						Log.e("WelcomeFragment:", "WrongResponseCode: " + response.code());
						break;
				}
			}

			@Override
			public void onFailure(Call<UserResponse> call, Throwable t){
				Log.e("WelcomeFragment:", "onFailure: " + t.getMessage());
			}
		});
	}

}
