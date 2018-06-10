package com.example.alam.proyectofinaldb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.util.ArrayList;

public class Genero extends AppCompatActivity {

    ListView listaDatos;
    ArrayList<datos_listView> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genero);
        listaDatos = (ListView)findViewById(R.id.listView);
        lista = new ArrayList<datos_listView>();


        lista.add(new datos_listView(1, "Acción", "Emocionate con las explosiones", R.drawable.ic_accion));
        lista.add(new datos_listView(2, "Aventura", "Viaja por el amazonas o descubre mundos mágicos", R.drawable.ic_aventura));
        lista.add(new datos_listView(3, "Ciencia ficción", "May the force be with you", R.drawable.ic_cienciaficcion));
        lista.add(new datos_listView(4, "Comedia", "Carcajada asegurada", R.drawable.ic_comedia));
        lista.add(new datos_listView(5, "Documental", "Porque aprender también puede ser divertido", R.drawable.ic_documental));
        lista.add(new datos_listView(6, "Horror", "Ni Dross da tanto miedo", R.drawable.ic_horror));
        lista.add(new datos_listView(7, "Musical", "A nadie le gustan, pero no hay más", R.drawable.ic_musical));
        lista.add(new datos_listView(8, "Romance", "Eres un mandilón", R.drawable.ic_romance));
        lista.add(new datos_listView(9, "Animación", "Diversión para los más pequeños", R.drawable.ic_animacion));
        lista.add(new datos_listView(10, "Drama", "Te gusta sufrir", R.drawable.ic_comedia));
        //lista.add(new datos_listView(db_id, db_titulo, db_sinopsis, db_imagen));

        adaptador_listView miadaptador = new adaptador_listView(getApplicationContext(), lista);
        listaDatos.setAdapter(miadaptador);
        final String tipo = getIntent().getStringExtra("tipo");

        listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    if(tipo.contentEquals(Data_utilities.tablaPeliculas)){
                        Intent myIntent = new Intent(view.getContext(), Peliculas.class);
                        myIntent.putExtra("genero", Data_utilities.qPeliculas +"Acción");
                        startActivity(myIntent);
                    }else{
                        Intent myIntent = new Intent(view.getContext(), Series.class);
                        myIntent.putExtra("genero", Data_utilities.qSeries +"Acción");
                        startActivity(myIntent);
                    }
                }if (position == 1){
                    if(tipo.contentEquals(Data_utilities.tablaPeliculas)){
                        Intent myIntent = new Intent(view.getContext(), Peliculas.class);
                        myIntent.putExtra("genero", Data_utilities.qPeliculas +"Aventura");
                        startActivity(myIntent);
                    }else{
                        Intent myIntent = new Intent(view.getContext(), Series.class);
                        myIntent.putExtra("genero", Data_utilities.qSeries +"Aventura");
                        startActivity(myIntent);
                    }
                }if (position == 2){
                    if(tipo.contentEquals(Data_utilities.tablaPeliculas)){
                        Intent myIntent = new Intent(view.getContext(), Peliculas.class);
                        myIntent.putExtra("genero", Data_utilities.qPeliculas +"Ciencia ficción");
                        startActivity(myIntent);
                    }else{
                        Intent myIntent = new Intent(view.getContext(), Series.class);
                        myIntent.putExtra("genero", Data_utilities.qSeries +"Ciencia ficción");
                        startActivity(myIntent);
                    }
                }if (position == 3){
                    if(tipo.contentEquals(Data_utilities.tablaPeliculas)){
                        Intent myIntent = new Intent(view.getContext(), Peliculas.class);
                        myIntent.putExtra("genero", Data_utilities.qPeliculas +"Comedia");
                        startActivity(myIntent);
                    }else{
                        Intent myIntent = new Intent(view.getContext(), Series.class);
                        myIntent.putExtra("genero", Data_utilities.qSeries +"Comedia");
                        startActivity(myIntent);
                    }
                }if (position == 4){
                    if(tipo.contentEquals(Data_utilities.tablaPeliculas)){
                        Intent myIntent = new Intent(view.getContext(), Peliculas.class);
                        myIntent.putExtra("genero", Data_utilities.qPeliculas +"Documental");
                        startActivity(myIntent);
                    }else{
                        Intent myIntent = new Intent(view.getContext(), Series.class);
                        myIntent.putExtra("genero", Data_utilities.qSeries +"Documental");
                        startActivity(myIntent);
                    }
                }if (position == 5){
                    if(tipo.contentEquals(Data_utilities.tablaPeliculas)){
                        Intent myIntent = new Intent(view.getContext(), Peliculas.class);
                        myIntent.putExtra("genero", Data_utilities.qPeliculas +"Horror");
                        startActivity(myIntent);
                    }else{
                        Intent myIntent = new Intent(view.getContext(), Series.class);
                        myIntent.putExtra("genero", Data_utilities.qSeries +"Horror");
                        startActivity(myIntent);
                    }
                }if (position == 6){
                    if(tipo.contentEquals(Data_utilities.tablaPeliculas)){
                        Intent myIntent = new Intent(view.getContext(), Peliculas.class);
                        myIntent.putExtra("genero", Data_utilities.qPeliculas +"Musical");
                        startActivity(myIntent);
                    }else{
                        Intent myIntent = new Intent(view.getContext(), Series.class);
                        myIntent.putExtra("genero", Data_utilities.qSeries +"Musical");
                        startActivity(myIntent);
                    }
                }if (position == 7){
                    if(tipo.contentEquals(Data_utilities.tablaPeliculas)){
                        Intent myIntent = new Intent(view.getContext(), Peliculas.class);
                        myIntent.putExtra("genero", Data_utilities.qPeliculas +"Romance");
                        startActivity(myIntent);
                    }else{
                        Intent myIntent = new Intent(view.getContext(), Series.class);
                        myIntent.putExtra("genero", Data_utilities.qSeries +"Romance");
                        startActivity(myIntent);
                    }
                }if (position == 8){
                    if(tipo.contentEquals(Data_utilities.tablaPeliculas)){
                        Intent myIntent = new Intent(view.getContext(), Peliculas.class);
                        myIntent.putExtra("genero", Data_utilities.qPeliculas +"Animación");
                        startActivity(myIntent);
                    }else{
                        Intent myIntent = new Intent(view.getContext(), Series.class);
                        myIntent.putExtra("genero", Data_utilities.qSeries +"Animación");
                        startActivity(myIntent);
                    }
                }if (position == 9){
                    if(tipo.contentEquals(Data_utilities.tablaPeliculas)){
                        Intent myIntent = new Intent(view.getContext(), Peliculas.class);
                        myIntent.putExtra("genero", Data_utilities.qPeliculas +"Drama");
                        startActivity(myIntent);
                    }else{
                        Intent myIntent = new Intent(view.getContext(), Series.class);
                        myIntent.putExtra("genero", Data_utilities.qSeries +"Drama");
                        startActivity(myIntent);
                    }
                }

            }
        });
    }
}
