package com.mfvargas.cinemaapp.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAdapter {
    private static IPelicula apiService;

    public static IPelicula getApiService(){

        final String baseUrl="https://api.themoviedb.org/3/movie/";

        if(apiService==null){
            Retrofit retrofit=new Retrofit
                    .Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService=retrofit.create(IPelicula.class);
        }
        return apiService;
    }
}
