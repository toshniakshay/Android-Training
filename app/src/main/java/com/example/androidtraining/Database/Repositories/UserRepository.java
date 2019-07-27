package com.example.androidtraining.Database.Repositories;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import com.example.androidtraining.Database.AppDatabase;
import com.example.androidtraining.Models.User;

import java.util.List;

/**
 * Repository class for User Ideally This class will have All the funtionality related to
 * caching data to database or calling API.
 */
@SuppressLint("StaticFieldLeak")
public class UserRepository {

    private AppDatabase mDatabase;

    public UserRepository(Context context) {
        mDatabase = AppDatabase.getInstance(context);
    }

    public void RegisterUserTask(final User user) {
        new AsyncTask<User, Void, Void>() {
            @Override
            protected Void doInBackground(User... users) {
                mDatabase.getUserDao().insert(users);
                return null;
            }
        }.execute(user);
    }

    public void GetUserTask(final String userId) {
        new AsyncTask<String, Void, Void>() {
            @Override
            protected Void doInBackground(String... integers) {
                mDatabase.getUserDao().findUserByEmail(userId);
                return null;
            }
        }.execute(userId);

    }

    public void updateUserTask(final User user) {
        new AsyncTask<User, Void, Void>() {

            @Override
            protected Void doInBackground(User... voids) {
                mDatabase.getUserDao().update(user);
                return null;
            }
        }.execute();
    }

    /**
     * Get list of all the users
     */
    public List<User> getUsersTask() {
        new AsyncTask<Void, Void, List<User>>() {

            @Override
            protected List<User> doInBackground(Void... voids) {
                return mDatabase.getUserDao().getAllUsers();
            }
        }.execute();

        return null;
    }

    /**
     * Delete a specified user from Database
     * @param user
     */
    public void deleteUserTask(User user) {
        new AsyncTask<User, Void, Void>() {
            @Override
            protected Void doInBackground(User... users) {
                mDatabase.getUserDao().delete(users[0]);
                return null;
            }
        }.execute(user);
    }
}
