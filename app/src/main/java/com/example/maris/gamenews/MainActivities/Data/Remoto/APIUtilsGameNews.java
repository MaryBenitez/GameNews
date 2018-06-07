package com.example.maris.gamenews.MainActivities.Data.Remoto;

//Clase que tiene la URL de la API como variable estatica

public class APIUtilsGameNews {

    private APIUtilsGameNews() {}

    //URL de API
    public static final String BASE_URL = "http://gamenewsuca.herokuapp.com/";

    public static APIServiceGameNews getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIServiceGameNews.class);

    }

}
