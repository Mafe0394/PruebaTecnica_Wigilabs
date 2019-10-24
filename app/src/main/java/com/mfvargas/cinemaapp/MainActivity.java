package com.mfvargas.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.mfvargas.cinemaapp.Retrofit.RetrofitAdapter;
import com.mfvargas.cinemaapp.Retrofit.IPelicula;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<ListaPeliculas> {

    //Colección de peliculas
    ArrayList<Pelicula> pelicula;
    private RecyclerView listaPeliculas;
    private ListaPeliculas peliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Traemos la información de la API
        Call<ListaPeliculas> call= RetrofitAdapter.getApiService().getPelicula();
        call.enqueue(this);

        //inicializamos ActionBar
        inicializarActionBar();

        //Objeto para manipular el RecyclerView
        listaPeliculas=findViewById(R.id.recView);

        //Elementos en una lista

        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaPeliculas.setLayoutManager(llm);
        inicializarListPeliculas();
        inicializarAdaptador();

    }

    public void inicializarAdaptador(){

    }

    public void inicializarListPeliculas(){


        pelicula=new ArrayList<Pelicula>();
        pelicula.add(new Pelicula("Marly y Yo","De un perrito",
                8.5,50,"dd","na",
                "2010-10-02"));
    }

    public void inicializarActionBar(){
        Toolbar miActionBar= findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
    }

    @Override
    public void onResponse(Call<ListaPeliculas> call, Response<ListaPeliculas> response) {
        ListaPeliculas peliculas=response.body();
        PeliculaAdaptador adaptador=new PeliculaAdaptador(peliculas,this);
        listaPeliculas.setAdapter(adaptador);

        Toast.makeText(this,"GENIAL!!! " + peliculas.getResults().size(),Toast.LENGTH_LONG).show();

    }

    @Override
    public void onFailure(Call<ListaPeliculas> call, Throwable t) {
        Toast.makeText(this,"Error: " + t.getMessage().toString(),Toast.LENGTH_LONG).show();
        Log.d("gato",t.getMessage().toString());

    }

//    @Override
//    public void onResponse(Call<ListaPeliculas> call, Response<ListaPeliculas> response) {
//        if(response.isSuccessful()){
//            peliculas=response.body();
//        }
//    }
//
//    @Override
//    public void onFailure(Call<ListaPeliculas> call, Throwable t) {
//        Toast.makeText(this,"Error: " + t.getMessage().toString(),Toast.LENGTH_SHORT).show();
//    }
}


