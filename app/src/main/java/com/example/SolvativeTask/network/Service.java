package com.example.SolvativeTask.network;

import com.example.SolvativeTask.model.Response;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service  {

    @GET("users?page=1")
    Call<Response> getList();
}
