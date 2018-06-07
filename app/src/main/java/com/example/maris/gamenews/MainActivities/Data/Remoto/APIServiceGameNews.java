package com.example.maris.gamenews.MainActivities.Data.Remoto;

//Interfaz que contiene los métodos a utilizar para ejecutar solicitudes HTTP

import com.example.maris.gamenews.MainActivities.Data.Model.LoginPOST;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface APIServiceGameNews {

    @POST("/login")
    @FormUrlEncoded
    Call<LoginPOST> savePost(@Field("user") String username, @Field("password") String password);

}
