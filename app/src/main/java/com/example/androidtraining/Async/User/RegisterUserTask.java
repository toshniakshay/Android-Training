package com.example.androidtraining.Async.User;

import android.os.AsyncTask;

import com.example.androidtraining.Database.UserDao;
import com.example.androidtraining.Models.User;

public class RegisterUserTask extends AsyncTask<User, Void, Void> {

    private UserDao mUserDao;

    public RegisterUserTask(UserDao userDao) {
        mUserDao = userDao;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(User... users) {
        mUserDao.insert(users);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
