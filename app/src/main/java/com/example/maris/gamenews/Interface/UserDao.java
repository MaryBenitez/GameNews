package com.example.maris.gamenews.Interface;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.maris.gamenews.Class.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE user_id IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE user LIKE :username AND "
            + "pass LIKE :password LIMIT 1")

    User findByName(String username, String password);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);

}
