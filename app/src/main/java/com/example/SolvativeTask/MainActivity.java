package com.example.SolvativeTask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;

import com.example.SolvativeTask.model.DataItem;
import com.example.SolvativeTask.model.Response;
import com.example.SolvativeTask.network.Event;
import com.example.SolvativeTask.network.Repository;
import com.example.SolvativeTask.room.DatabaseClient;
import com.example.SolvativeTask.viewmodel.MyViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserRecyclerAdapter userRecyclerAdapter;
     MyViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MyViewModel.class);
        initviews();
    }

    private void initviews() {
        recyclerView = findViewById(R.id.recycler_view);
       List<DataItem> dataItems  = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userRecyclerAdapter = new UserRecyclerAdapter();
        recyclerView.setAdapter(userRecyclerAdapter);

        viewModel.items.observe(this, new Observer<List<DataItem>>() {
            @Override
            public void onChanged(List<DataItem> dataItems) {
                userRecyclerAdapter.submitList(dataItems);
            }
        });



//        Repository.getInstance().getList(new Event() {
//            @Override
//            public void success(Response response) {
//                userRecyclerAdapter.submitList(response.getData());
//
//              /*  for(int i = 0 ;i <response.getData().size();i++){
//                    addTODataBase(response.getData().get(i));
//                }*/
//            }
//            @Override
//            public void fail() {
//               /*userRecyclerAdapter.submitList( DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
//                        .dao()
//                        .getAll());*/
//            }
//        });

    }


}