package com.example.SolvativeTask.network;

import com.example.SolvativeTask.model.Response;

public class Repository {
    private static final Object LOCK = new Object();
    private static Repository repository;
    private  DataSource dataSource;

    public Repository(DataSource dataSource){
        this.dataSource = dataSource;
    }
    public static Repository getInstance(){
        if(repository==null){
            synchronized (LOCK){
                repository = new Repository(DataSource.getInstance());
            }
        }
        return repository;
    }


    public void getList(Event event){
        dataSource.getList(event);
    }
}
