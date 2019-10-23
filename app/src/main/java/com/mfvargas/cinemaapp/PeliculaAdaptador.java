package com.mfvargas.cinemaapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//<> Recibe una colección de películas viewHolder
public class PeliculaAdaptador extends RecyclerView.Adapter<PeliculaAdaptador.PeliculaViewHolder>{


    ArrayList<Pelicula> peliculas;
    Activity activity;

    //constructor
    public PeliculaAdaptador(ArrayList<Pelicula> peliculas, Activity activity){
        this.peliculas=peliculas;
        this.activity=activity;
    }


    //Le da vida al cardView
    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflador: le da vida al layout cardView
        //Layout que recicla el RecyclerView
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pelicula,
                parent,false);

        return new PeliculaViewHolder(v);
    }


    //Adapta los objetos a cada cardView
    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder peliculaViewHolder, int position) {
        //Seteamos cada uno de los elementos
        final Pelicula pelicula=peliculas.get(position);
        peliculaViewHolder.vistaPrevia.setImageResource(pelicula.getPoster_path());
        peliculaViewHolder.titulo.setText(pelicula.getTitle());
        peliculaViewHolder.descripcion.setText(pelicula.getOverview());

        peliculaViewHolder.vistaPrevia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,pelicula.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Cantidad de elementos que contiene mi lista
    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    //Clase inner static que se pueda utilizar
    //ViewHolder: ayuda a crear objetos y asociarlos
    //Ayuda a darle vida a los view
    public static class PeliculaViewHolder extends RecyclerView.ViewHolder {

        //Declaramos todos los views
        private ImageView vistaPrevia;
        private TextView titulo;
        private TextView descripcion;

        //Hace match con la superclase
        public PeliculaViewHolder(@NonNull View itemView) {
            super(itemView);
            //Asociamos cada objeto con su respectivo View
            vistaPrevia=itemView.findViewById(R.id.vp_ImageView);
            titulo=itemView.findViewById(R.id.vp_Titulo);
            descripcion=itemView.findViewById(R.id.vp_descripcion);
        }
    }

}
