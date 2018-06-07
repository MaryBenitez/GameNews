package com.example.maris.gamenews.Interface;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.maris.gamenews.Class.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertAll(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM User")
    LiveData<List<User>> getAll();

    @Query("SELECT * FROM User WHERE user_id IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM User WHERE fav IN (:favorite)")
    List<User> loadAllByFav(boolean[] favorite);

    @Query("SELECT * FROM User WHERE user LIKE :username AND "
            + "pass LIKE :password LIMIT 8")


    User findByName(String username, String password);

}
