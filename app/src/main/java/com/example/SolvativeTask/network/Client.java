package com.example.SolvativeTask.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.HTTP;

public class Client {

    private static final Object LOCK = new Object();
    private static Service service;

    public static Service getService(){
        if(service==null){
            synchronized (LOCK){
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
                httpClient.addInterceptor(interceptor);
                httpClient.readTimeout(4, TimeUnit.SECONDS);
                httpClient.writeTimeout(4, TimeUnit.SECONDS);

                service = new Retrofit.Builder()
                        .baseUrl("https://reqres.in/api/")
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(Service.class);
            }
        }
        return service;
    }
}
