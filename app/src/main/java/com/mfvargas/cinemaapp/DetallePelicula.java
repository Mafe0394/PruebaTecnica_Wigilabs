package com.mfvargas.cinemaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

public class DetallePelicula extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);



        Toolbar miActionBar= findViewById(R.id.miActionBar);
        miActionBar.setTitle("Detalles");
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle parametros=getIntent().getExtras();
        String titulo=parametros.getString("titulo");
        String descripcion =parametros.getString("descripcion");

        TextView tvTitulo=findViewById(R.id.Titulo);
        TextView tvDescripción=findViewById(R.id.Descripcion);

        tvTitulo.setText(titulo);
        tvDescripción.setText(descripcion);
    }
}
