package com.mfvargas.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Layout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextClock;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

public class DetallePelicula extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);

        //Traemos los datos que necesitamos
        Bundle parametros=getIntent().getExtras();
        String titulo=parametros.getString("titulo");
        String descripcion =parametros.getString("descripcion");
        float votacion=parametros.getFloat("votacion");
        String fecha=parametros.getString("fecha");
        double popularidad=parametros.getDouble("popularidad");
        String image_path="https://image.tmdb.org/t/p/w600_and_h900_bestv2"+parametros.getString("imagen");






        //Toolbar
        Toolbar miActionBar= findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView tvTitulo=findViewById(R.id.Titulo);
        TextView tvDescripción=findViewById(R.id.Descripcion);
        ImageView imImagen=findViewById(R.id.mainImage);
        TextView tvVotacion=findViewById(R.id.Votacion);
        TextView tvFecha=findViewById(R.id.Fecha);
        TextView tvPopularidad=findViewById(R.id.Popularidad);
        RatingBar ratingBar=findViewById(R.id.Rating);





        ratingBar.setRating(votacion/2);
        tvTitulo.setText(titulo.toUpperCase());
        tvDescripción.setText(descripcion);
        Picasso.get().load(image_path).into(imImagen);
        tvVotacion.setText(Float.toString(votacion));
        tvFecha.setText(fecha);
        tvPopularidad.setText(Double.toString(popularidad));
    }
}
