package com.example.alam.proyectofinaldb;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alam.proyectofinaldb.Entidades.Entidades_peliculas;
import com.example.alam.proyectofinaldb.Entidades.Entidades_series;
import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.util.ArrayList;

public class Todas_peliculas extends AppCompatActivity {

    ListView listaDatos;
    ArrayList<datos_listView> lista;
    ArrayList<Entidades_peliculas> listaPeliculas;
    ArrayList<Entidades_series> listaSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todas_peliculas);

        String tipo = getIntent().getStringExtra("tipo");

        listaDatos = (ListView)findViewById(R.id.listView);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String query = null;


        if(tipo.contentEquals("Data_utilities.tablaPeliculas")){

            String temporal = "Peliculas";

            Entidades_peliculas pelicula = null;
            listaPeliculas = new ArrayList<Entidades_peliculas>();

            query = "select "+ Data_utilities.PcampoId+", "+Data_utilities.PcampoTitulo+", "+Data_utilities.PcampoSinopsis+", "
                    +Data_utilities.PcampoImg+" from "+temporal;

            Cursor fila = db.rawQuery(query,null);

            while(fila.moveToNext()){
                pelicula = new Entidades_peliculas();
                pelicula.setPeliculas_id(fila.getInt(0));
                pelicula.setPeliculas_titulo(fila.getString(1));
                pelicula.setPeliculas_sinopsis(fila.getString(2));
                pelicula.setPeliculas_imagen(fila.getInt(3));

                listaPeliculas.add(pelicula);
            }

            lista = new ArrayList<datos_listView>();

            for (int i=0;i<listaPeliculas.size();i++){
                lista.add(new datos_listView(listaPeliculas.get(i).getPeliculas_id(), listaPeliculas.get(i).getPeliculas_titulo(), listaPeliculas.get(i).getPeliculas_sinopsis(), listaPeliculas.get(i).getPeliculas_imagen()));
            }

            adaptador_listView miadaptador = new adaptador_listView(getApplicationContext(), lista);
            listaDatos.setAdapter(miadaptador);

            listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String userId = getIntent().getStringExtra("userId");
                    String genero = getIntent().getStringExtra("genero");
                    String tipo = getIntent().getStringExtra("tipo");
                    int pelicula = listaPeliculas.get(position).getPeliculas_id();
                    String nomPeli = listaPeliculas.get(position).getPeliculas_titulo();
                    String peliculaId = String.valueOf(pelicula);
                    Intent myIntent = new Intent(view.getContext(), Ver_pelicula.class);
                    myIntent.putExtra("peliculaId", peliculaId);
                    myIntent.putExtra("nomPeli", nomPeli);
                    myIntent.putExtra("tipo", tipo);
                    myIntent.putExtra("genero", genero);
                    myIntent.putExtra("userId", userId);
                    startActivity(myIntent);
                }
            });
        }if(tipo.contentEquals("Data_utilities.tablaSeries")){

            String temporal = "Series";

            query = "select "+ Data_utilities.ScampoId+", "+Data_utilities.ScampoTitulo+", "+Data_utilities.ScampoSinopsis+", "
                    +Data_utilities.ScampoImg+" from "+temporal;

            Entidades_series serie = null;
            listaSeries = new ArrayList<Entidades_series>();

            Cursor fila = db.rawQuery(query,null);

            while(fila.moveToNext()){
                serie = new Entidades_series();
                serie.setSeries_id(fila.getInt(0));
                serie.setSeries_titulo(fila.getString(1));
                serie.setSeries_sinopsis(fila.getString(2));
                serie.setSeries_imagen(fila.getInt(3));

                listaSeries.add(serie);
            }

            lista = new ArrayList<datos_listView>();

            for (int i=0;i<listaSeries.size();i++){
                lista.add(new datos_listView(listaSeries.get(i).getSeries_id(), listaSeries.get(i).getSeries_titulo(), listaSeries.get(i).getSeries_sinopsis(), listaSeries.get(i).getSeries_imagen()));
            }

            adaptador_listView miadaptador = new adaptador_listView(getApplicationContext(), lista);
            listaDatos.setAdapter(miadaptador);

            listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String userId = getIntent().getStringExtra("userId");
                    int serieId = listaSeries.get(position).getSeries_id();
                    String serie = String.valueOf(serieId);
                    String genero = getIntent().getStringExtra("genero");
                    String tipo = getIntent().getStringExtra("tipo");
                    Intent myIntent = new Intent(view.getContext(), Ver_series.class);
                    myIntent.putExtra("serie", serie);
                    myIntent.putExtra("userId", userId);
                    myIntent.putExtra("genero", genero);
                    myIntent.putExtra("tipo", tipo);
                    startActivity(myIntent);
                }
            });
        }
    }

    public void Perfil (View view){
        Intent myIntent = new Intent(view.getContext(), Perfil.class);
        String userId = getIntent().getStringExtra("userId");
        myIntent.putExtra("userId", userId);
        startActivity(myIntent);
    }
    public void RegresaGenero(View view){
        String userId = getIntent().getStringExtra("userId");
        String genero = getIntent().getStringExtra("genero");
        String tipo = getIntent().getStringExtra("tipo");
        Intent myIntent = new Intent(view.getContext(), Genero.class);
        myIntent.putExtra("genero", genero);
        myIntent.putExtra("userId", userId);
        myIntent.putExtra("tipo", tipo);
        startActivity(myIntent);
    }
}