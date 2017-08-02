package com.lab.a2.pugman.basearchwithdagger.main;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lab.a2.pugman.basearchwithdagger.R;
import com.lab.a2.pugman.basearchwithdagger.base.BaseActivity;
import com.lab.a2.pugman.basearchwithdagger.main.fragments.WelcomeFragment;
import com.lab.a2.pugman.basearchwithdagger.utils.FragmentHelper;

import javax.inject.Inject;

/**
 * Created by pugman on 21.07.17.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */


public class MainActivity extends BaseActivity implements MainView{

	@Inject
	FragmentHelper    fragmentHelper;
	@Inject
	MainPresenterImpl presenter;

	private EditText mEditText;

	@Override
	protected int getLayoutId(){
		return R.layout.activity_main;
	}

	@Override
	protected void bindViews(){
		mEditText = (EditText) findViewById(R.id.userName);
	}

	@Override
	public void loginSuccess(){
		fragmentHelper.add(WelcomeFragment.newInstance(mEditText.getText().toString()), R.id.container);
		Toast.makeText(getApplicationContext(), "User logged in successfully", Toast.LENGTH_LONG).show();
	}

	public void onLoginClick(View view){
		if(!mEditText.getText().toString().isEmpty()) {
			presenter.loginUser(mEditText.getText().toString());
		}
	}
}
