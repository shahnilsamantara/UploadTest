package com.example.SolvativeTask.room;

import androidx.room.RoomDatabase;

import com.example.SolvativeTask.model.DataItem;


    @androidx.room.Database(entities = {DataItem.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract dao dao();
    }
