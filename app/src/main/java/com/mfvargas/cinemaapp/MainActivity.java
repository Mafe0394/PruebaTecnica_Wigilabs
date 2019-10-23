package com.mfvargas.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Colección de peliculas
    ArrayList<Pelicula> pelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


        //Llenamos vector con los títulos
        ArrayList<String> titulosPelicula = new ArrayList<>();
        for (Pelicula peliculas:pelicula
             ) {
            titulosPelicula.add(peliculas.getTitle());
        }
    }
}
