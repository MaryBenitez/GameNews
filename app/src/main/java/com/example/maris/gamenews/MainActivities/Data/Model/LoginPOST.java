package com.example.maris.gamenews.MainActivities.Data.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginPOST {

    @SerializedName("token")
    @Expose
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginPOST{" +
                "token='" + token + '\'' +
                '}';
    }

}
