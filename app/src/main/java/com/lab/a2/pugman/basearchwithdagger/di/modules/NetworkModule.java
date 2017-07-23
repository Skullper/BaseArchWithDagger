package com.lab.a2.pugman.basearchwithdagger.di.modules;

import com.lab.a2.pugman.basearchwithdagger.App;
import com.lab.a2.pugman.basearchwithdagger.BuildConfig;
import com.lab.a2.pugman.basearchwithdagger.R;
import com.lab.a2.pugman.basearchwithdagger.api.AppApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by pugman on 23.07.17.
 */

@Module
public class NetworkModule{

	@Provides
	@Singleton
	OkHttpClient providesOkHttpClient(){
		final OkHttpClient.Builder builder = new OkHttpClient.Builder();

		if (BuildConfig.DEBUG) {
			HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
			logging.setLevel(HttpLoggingInterceptor.Level.BODY);
			builder.addInterceptor(logging);
		}

		builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
				.readTimeout(60 * 1000, TimeUnit.MILLISECONDS);

		return builder.build();
	}

	@Provides
	@Singleton
	Retrofit providesRetrofit(App app, OkHttpClient client){
		return new Retrofit.Builder()
				.baseUrl(app.getString(R.string.end_point))
				.addConverterFactory(MoshiConverterFactory.create())
				.client(client)
				.build();
	}

	@Provides
	@Singleton
	AppApiService providesAppService(Retrofit retrofit){
		return retrofit.create(AppApiService.class);
	}
}
