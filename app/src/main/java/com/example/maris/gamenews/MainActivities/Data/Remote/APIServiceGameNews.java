package com.example.maris.gamenews.MainActivities.Data.Remote;

//Interfaz que contiene los métodos a utilizar para ejecutar solicitudes HTTP



import com.example.maris.gamenews.MainActivities.Data.Model.Request;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;


public interface APIServiceGameNews {

    @POST("/login")
    @FormUrlEncoded
    Observable<Request> savePost(@Field("user") String username, @Field("password") String password);


    @GET("/news")
    Call<Request[]> get(@Header("Authorization: ") String token);

}
