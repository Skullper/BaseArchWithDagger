package com.lab.a2.pugman.basearchwithdagger.main.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lab.a2.pugman.basearchwithdagger.R;
import com.lab.a2.pugman.basearchwithdagger.api.AppApiService;
import com.lab.a2.pugman.basearchwithdagger.api.UserResponse;
import com.lab.a2.pugman.basearchwithdagger.main.MainActivity;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pugman on 23.07.17.
 */

public class WelcomeFragment extends Fragment{

	public static final String EXTRA_USER_NAME = "user.name";

	@Inject
	AppApiService appApiService;

	private MainActivity activity;

	public static WelcomeFragment newInstance(String name){
		Bundle args = new Bundle();
		args.putString(EXTRA_USER_NAME, name);
		WelcomeFragment fragment = new WelcomeFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onAttach(Context context){
		activity = (MainActivity) context;
		AndroidSupportInjection.inject(this);
		super.onAttach(context);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
		return inflater.inflate(R.layout.fragment_welcome, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
		super.onViewCreated(view, savedInstanceState);
		String userName = getArguments().getString(EXTRA_USER_NAME, "Empty");
		TextView welcomeText = (TextView) view.findViewById(R.id.welcomeTv);
		welcomeText.setText(userName);
		appApiService.getUser(userName).enqueue(new Callback<UserResponse>(){
			@Override
			public void onResponse(Call<UserResponse> call, Response<UserResponse> response){
				switch(response.code()){
					case 200:
						Toast.makeText(activity.getApplicationContext(), "Restart", Toast.LENGTH_LONG).show();
						break;
					default:
						Log.e("WelcomeFragment:", "WrongResponseCode: "+response.code());
						break;
				}
			}

			@Override
			public void onFailure(Call<UserResponse> call, Throwable t){
				Log.e("WelcomeFragment:", "onFailure: "+t.getMessage());
			}
		});
	}
}
