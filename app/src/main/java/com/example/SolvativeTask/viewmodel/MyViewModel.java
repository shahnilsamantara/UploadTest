package com.example.SolvativeTask.viewmodel;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.SolvativeTask.model.DataItem;
import com.example.SolvativeTask.model.Response;
import com.example.SolvativeTask.network.Event;
import com.example.SolvativeTask.network.Repository;
import com.example.SolvativeTask.room.DatabaseClient;

import java.util.List;

public class MyViewModel extends androidx.lifecycle.ViewModel {

    public  MutableLiveData<List<DataItem>> items ;
    Repository repository ;
    Context context;

    public MyViewModel(Context context){
       repository = Repository.getInstance();
       items = new MutableLiveData<>();
       this.context = context;
       getData();
    }

    public void getData(){
        repository.getList(new Event() {
            @Override
            public void success(Response object) {
                items.postValue(object.getData());
                for(int i = 0 ;i <object.getData().size();i++){
                    addTODataBase(object.getData().get(i));
                }
            }

            @Override
            public void fail() {
                items.postValue(DatabaseClient.getInstance(context).getAppDatabase()
                        .dao()
                        .getAll());
            }
        });
    }

    private void addTODataBase(DataItem dataItem){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                DatabaseClient.getInstance(context).getAppDatabase()
                        .dao()
                        .insert(dataItem);
            }
        });
    }

}
