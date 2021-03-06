package com.example.maris.gamenews.RoomDataBase.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.maris.gamenews.Class.User;
import com.example.maris.gamenews.RoomDataBase.Interface.UserDao;
import com.example.maris.gamenews.RoomDataBase.AppDataBase;

import java.util.List;

public class UserRepository {

    private UserDao mUserDao;
    private LiveData<List<User>> mAllUsers;

    public UserRepository(Application application){

        AppDataBase dataBase = AppDataBase.getDatabse(application);
        mUserDao = dataBase.userDao();
        mAllUsers = mUserDao.getAll();

    }

    public LiveData<List<User>> getAll(){
        return mAllUsers;
    }

    public void insertAll(User users){
       new insertAsyncTask(mUserDao).execute(users);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void>{

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.insertAll(params[0]);
            return null;
        }

    }

}
