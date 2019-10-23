package com.mfvargas.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Colección de peliculas
    ArrayList<Pelicula> pelicula;
    private RecyclerView listaPeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar miActionBar= findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);

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
        PeliculaAdaptador adaptador=new PeliculaAdaptador(pelicula,this);
        listaPeliculas.setAdapter(adaptador);
    }

    public void inicializarListPeliculas(){
        pelicula=new ArrayList<Pelicula>();
        pelicula.add(new Pelicula("Marly y Yo","De un perrito",
                8.5,50,R.drawable.iconoapp,"na",
                "2010-10-02"));
        pelicula.add(new Pelicula("Cenicienta","En tu cara perra",
                2.5,5,R.drawable.iconoapp,"na",
                "2010-10-02"));
        pelicula.add(new Pelicula("Los cheveres","Saben cocinar",
                8.5,50,R.drawable.iconoapp,"na",
                "2010-10-25"));
        pelicula.add(new Pelicula("Marly y Yo","De un perrito",
                8.5,50,R.drawable.iconoapp,"na",
                "2010-10-02"));
        pelicula.add(new Pelicula("Cenicienta","En tu cara perra",
                2.5,5,R.drawable.iconoapp,"na",
                "2010-10-02"));
        pelicula.add(new Pelicula("Los cheveres","Saben cocinar",
                8.5,50,R.drawable.iconoapp,"na",
                "2010-10-25"));
        pelicula.add(new Pelicula("Marly y Yo","De un perrito",
                8.5,50,R.drawable.iconoapp,"na",
                "2010-10-02"));
        pelicula.add(new Pelicula("Cenicienta","En tu cara perra",
                2.5,5,R.drawable.iconoapp,"na",
                "2010-10-02"));
        pelicula.add(new Pelicula("Los cheveres","Saben cocinar",
                8.5,50,R.drawable.iconoapp,"na",
                "2010-10-25"));
        pelicula.add(new Pelicula("Marly y Yo","De un perrito",
                8.5,50,R.drawable.iconoapp,"na",
                "2010-10-02"));
        pelicula.add(new Pelicula("Cenicienta","En tu cara perra",
                2.5,5,R.drawable.iconoapp,"na",
                "2010-10-02"));
        pelicula.add(new Pelicula("Los cheveres","Saben cocinar",
                8.5,50,R.drawable.iconoapp,"na",
                "2010-10-25"));
    }
}


