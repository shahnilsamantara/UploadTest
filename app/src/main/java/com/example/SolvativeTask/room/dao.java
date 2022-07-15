package com.example.SolvativeTask.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.SolvativeTask.model.DataItem;

import java.util.List;

@Dao
public interface dao {

    @Query("SELECT * FROM users_table")
    List<DataItem> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DataItem dataItem);
}
