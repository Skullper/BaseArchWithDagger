package com.lab.a2.pugman.basearchwithdagger.main;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lab.a2.pugman.basearchwithdagger.R;
import com.lab.a2.pugman.basearchwithdagger.base.BaseActivity;
import com.lab.a2.pugman.basearchwithdagger.main.fragments.WelcomeFragment;

import javax.inject.Inject;

/**
 * Created by pugman on 21.07.17.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */


public class MainActivity extends BaseActivity implements MainView{

	@Inject
	FragmentManager                      fragmentManager;
	@Inject
	MainPresenterImpl                    presenter;

	private EditText editText;

	@Override
	protected int getLayoutId(){
		return R.layout.activity_main;
	}

	@Override
	protected void bindViews(){
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
}
