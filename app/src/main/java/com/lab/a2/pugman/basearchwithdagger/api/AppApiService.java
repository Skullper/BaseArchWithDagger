package com.lab.a2.pugman.basearchwithdagger.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by pugman on 23.07.17.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

public interface AppApiService{

	@GET("/users/{username}")
	Call<UserResponse> getUser(
			@Path("username") String username
	);
}
