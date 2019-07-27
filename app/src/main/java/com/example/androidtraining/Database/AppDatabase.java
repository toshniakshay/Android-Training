package com.example.androidtraining.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.androidtraining.Models.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "user_db";

    private static AppDatabase instance;

    /**
     * Only one object of database will shared across application
     *
     * @param context : for creating object
     * @return : Database class instance
     */
    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    DATABASE_NAME
            ).build();
        }
        return instance;
    }

    public abstract UserDao getUserDao();
}
