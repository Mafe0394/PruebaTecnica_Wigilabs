package com.mfvargas.cinemaapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//<> Recibe una colección de películas viewHolder
public class PeliculaAdaptador extends RecyclerView.Adapter<PeliculaAdaptador.PeliculaViewHolder>{


    ListaPeliculas peliculas;
    Activity activity;

    //constructor
    public PeliculaAdaptador(ListaPeliculas peliculas, Activity activity){
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
    public void onBindViewHolder(@NonNull PeliculaViewHolder peliculaViewHolder, final int position) {
        //Seteamos cada uno de los elementos
        final Pelicula pelicula=peliculas.getResults().get(position);
        Picasso.get().load("https://image.tmdb.org/t/p/w185_and_h278_bestv2" + pelicula.getPoster_path()).into(peliculaViewHolder.vistaPrevia);;
        peliculaViewHolder.titulo.setText(pelicula.getTitle());
        String resumen=pelicula.getOverview();
        if(pelicula.getOverview().length()>200)
            resumen=resumen.substring(0,200) + "...";

            peliculaViewHolder.descripcion.setText(resumen);

        peliculaViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,pelicula.getTitle(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(activity,DetallePelicula.class);
                intent.putExtra("titulo",pelicula.getTitle());
                intent.putExtra("descripcion",pelicula.getOverview());
                intent.putExtra("votacion",pelicula.getVote_average());
                intent.putExtra("fecha",pelicula.getRelease_date());
                intent.putExtra("popularidad",pelicula.getPopularity());
                intent.putExtra("imagen",pelicula.getPoster_path());
                intent.putExtra("posicion",position);
                activity.startActivity(intent);
            }
        });
    }

    //Cantidad de elementos que contiene mi lista
    @Override
    public int getItemCount() {
        return peliculas.getResults().size();
    }

    //Clase inner static que se pueda utilizar
    //ViewHolder: ayuda a crear objetos y asociarlos
    //Ayuda a darle vida a los view
    public static class PeliculaViewHolder extends RecyclerView.ViewHolder {

        //Declaramos todos los views
        private ImageView vistaPrevia;
        private TextView titulo;
        private TextView descripcion;
        private CardView cardView;


        //Hace match con la superclase
        public PeliculaViewHolder(@NonNull View itemView) {
            super(itemView);
            //Asociamos cada objeto con su respectivo View
            vistaPrevia=itemView.findViewById(R.id.vp_ImageView);
            titulo=itemView.findViewById(R.id.vp_Titulo);
            descripcion=itemView.findViewById(R.id.vp_descripcion);
            cardView=itemView.findViewById(R.id.cvPelicula);
        }
    }

}
