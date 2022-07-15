package com.example.SolvativeTask.network;

import com.example.SolvativeTask.model.Response;

import retrofit2.Call;
import retrofit2.Callback;

public class DataSource {
    private static final Object LOCK = new Object();
    private static DataSource dataSource;
    private Service service ;

    public DataSource(Service service){
        this.service = service;
    }


    public static DataSource getInstance(){
        if(dataSource==null){
            synchronized (LOCK){
                dataSource = new DataSource(Client.getService());
            }
        }
        return dataSource;
    }


    public void getList(Event event){
        service.getList().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful())
                event.success(response.body());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                event.fail();
            }
        });
    }
}
