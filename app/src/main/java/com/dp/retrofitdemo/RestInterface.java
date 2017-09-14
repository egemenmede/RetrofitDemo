package com.dp.retrofitdemo;


import com.dp.pojo.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by egemenmede on 14/09/2017.
 */

public interface RestInterface {

    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

}
