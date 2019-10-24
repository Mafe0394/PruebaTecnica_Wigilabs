package com.mfvargas.cinemaapp.Retrofit;

import com.mfvargas.cinemaapp.ListaPeliculas;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IPelicula {
    @GET("popular?api_key=09963e300150f9831c46a1828a82a984&language=en-US/")
    Call<ListaPeliculas>getPelicula();
}
