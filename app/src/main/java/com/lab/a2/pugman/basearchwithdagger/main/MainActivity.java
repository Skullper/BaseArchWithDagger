package com.lab.a2.pugman.basearchwithdagger.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lab.a2.pugman.basearchwithdagger.R;
import com.lab.a2.pugman.basearchwithdagger.main.fragments.WelcomeFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by pugman on 21.07.17.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */


public class MainActivity extends AppCompatActivity implements MainView, HasSupportFragmentInjector{

	@Inject
	FragmentManager                      fragmentManager;
	@Inject
	MainPresenterImpl                    presenter;
	@Inject
	DispatchingAndroidInjector<Fragment> fragmentInjector;

	private EditText editText;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState){
		AndroidInjection.inject(this);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText = (EditText) findViewById(R.id.userName);
	}

	@Override
	public void loginSuccess(){
		fragmentManager.beginTransaction().add(R.id.container, WelcomeFragment.newInstance(editText.getText().toString()), "Welcome").commitAllowingStateLoss();
		Toast.makeText(getApplicationContext(), "User logged in successfully", Toast.LENGTH_LONG).show();
	}

	public void onLoginClick(View view){
		if(!editText.getText().toString().isEmpty()) {
			presenter.loginUser(editText.getText().toString());
		}
	}

	@Override
	public AndroidInjector<Fragment> supportFragmentInjector(){
		return fragmentInjector;
	}
}
