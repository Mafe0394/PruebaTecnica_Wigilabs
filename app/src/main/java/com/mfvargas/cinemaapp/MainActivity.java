package com.mfvargas.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.mfvargas.cinemaapp.Retrofit.RetrofitAdapter;
import com.mfvargas.cinemaapp.Retrofit.IPelicula;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<ListaPeliculas> {

    //Colección de peliculas
    ArrayList<Pelicula> pelicula;
    private RecyclerView listaPeliculas;
    private ListaPeliculas peliculas;
    private SwipeRefreshLayout myRefresh;
    Call<ListaPeliculas> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Views
        myRefresh=findViewById(R.id.Refresh);
        listaPeliculas=findViewById(R.id.recView);



        //Toast.makeText(this,Locale.getDefault().getLanguage(),Toast.LENGTH_LONG).show();

        //Obtener data
        if(Locale.getDefault().getLanguage()=="es") {
            call= RetrofitAdapter.getApiService().getPeliculaes();
        } else {
            call= RetrofitAdapter.getApiService().getPelicula();
        }
        call.enqueue(this);

        //inicializamos ActionBar
        inicializarActionBar();
        myRefresh.setColorSchemeColors(getResources().getColor(R.color.colorAccent));



        //Elementos del recycler View acomodados en vista de Lista
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Construcción RecyclerView
        listaPeliculas.setLayoutManager(llm);

        //método para controlar el gesto refresh
        myRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });


    }

    //Llama nuevamente el contenido para refrescar el recyclerView
    public void refrescandoContenido(){
        if(Locale.getDefault().getLanguage()=="es") {
            call= RetrofitAdapter.getApiService().getPeliculaes();
        } else {
            call= RetrofitAdapter.getApiService().getPelicula();
        }
        call.enqueue(this);
        myRefresh.setRefreshing(false);
    }



    //Inicialización ActionBar
    public void inicializarActionBar(){
        Toolbar miActionBar= findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
    }

    //La obtención de los datos fue exitosa
    @Override
    public void onResponse(Call<ListaPeliculas> call, Response<ListaPeliculas> response) {
        ListaPeliculas peliculas=response.body();
        PeliculaAdaptador adaptador=new PeliculaAdaptador(peliculas,this);
        listaPeliculas.setAdapter(adaptador);

    }

    @Override
    public void onFailure(Call<ListaPeliculas> call, Throwable t) {
        Toast.makeText(this,"Error al cargar los datos",Toast.LENGTH_LONG).show();
        Log.d("Error, revisar",t.getMessage().toString());

    }

}


