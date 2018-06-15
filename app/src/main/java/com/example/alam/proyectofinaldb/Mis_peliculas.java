package com.example.alam.proyectofinaldb;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.alam.proyectofinaldb.Entidades.Entidades_peliculas;
import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.util.ArrayList;

public class Mis_peliculas extends AppCompatActivity {

    ListView listaDatos;
    ArrayList<datos_listView> lista;
    ArrayList<Entidades_peliculas> listaPeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_peliculas);

        String userId = getIntent().getStringExtra("userId");

        listaDatos = (ListView)findViewById(R.id.listView);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Entidades_peliculas pelicula = null;
        listaPeliculas = new ArrayList<Entidades_peliculas>();

        String query = "select "+ Data_utilities.PcampoId+", "+Data_utilities.PcampoTitulo+", "+Data_utilities.PcampoSinopsis+", "+Data_utilities.PcampoImg+" from "+Data_utilities.tablaPeliculas
                +" inner join "+Data_utilities.tablaPeliculasUsuarios+" on "+Data_utilities.PUcampoPeliculasID+" = "+Data_utilities.PcampoId
                +" inner join "+Data_utilities.tablaUsuarios+" on "+Data_utilities.UcampoId+" = "+Data_utilities.PUcampoUsuariosID+" where "+Data_utilities.UcampoId+" = '"+userId+"'";

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
                String titulo = listaPeliculas.get(position).getPeliculas_titulo();
                Intent myIntent = new Intent(view.getContext(), Ver_pelicula.class);
                myIntent.putExtra("titulo", titulo);
                myIntent.putExtra("userId", userId);
                startActivity(myIntent);
            }
        });
    }
}
