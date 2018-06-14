package com.example.maris.gamenews.Class;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @PrimaryKey
    private  int user_id;

    @ColumnInfo(name = "user")
    private String username;

    @ColumnInfo(name = "pass")
    private String password;

    @ColumnInfo(name = "fav")
    private ArrayList<String> favorite = new ArrayList<>();

    //constructor
    public User(int user_id, String username, String password, ArrayList<String> favorite) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.favorite.addAll(favorite);
    }

    //setters and getters
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getFavorite() {
        return favorite;
    }
    public void setFavorite(ArrayList<String> favorite) {
        this.favorite = favorite;
    }
}
