package com.example.alam.proyectofinaldb;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.alam.proyectofinaldb.Entidades.Entidades_series;
import com.example.alam.proyectofinaldb.Entidades.Entidades_temporadas;
import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.util.ArrayList;

public class Ver_serie extends AppCompatActivity {

    ListView listaDatos;
    ArrayList<datos_listView> lista;
    ArrayList<Entidades_temporadas> listaTemporadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_serie);

        String serie = getIntent().getStringExtra("serie");

        listaDatos = (ListView)findViewById(R.id.listView);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Entidades_temporadas temporada = null;
        listaTemporadas = new ArrayList<Entidades_temporadas>();

        String query = "select "+ Data_utilities.TcampoId+", "+Data_utilities.TcampoTitulo+", "+Data_utilities.TcampoImg+" from "+Data_utilities.tablaTempoaradas
                +" where "+Data_utilities.TcampoSeriesID+" like '"+serie+"'";

        Cursor fila = db.rawQuery(query,null);

        while(fila.moveToNext()){
            temporada = new Entidades_temporadas();
            temporada.setTemporadas_id(fila.getInt(0));
            temporada.setTemporadas_titulo(fila.getString(1));
            temporada.setTemporadas_series_id(fila.getInt(2));
            temporada.setTemporadas_imagen(fila.getInt(3));

            listaTemporadas.add(temporada);
        }

        lista = new ArrayList<datos_listView>();

        for (int i=0;i<listaTemporadas.size();i++){
            lista.add(new datos_listView(listaTemporadas.get(i).getTemporadas_id(), listaTemporadas.get(i).getTemporadas_titulo(), listaTemporadas.get(i).getTemporadas_imagen()));
        }

        adaptador_listView miadaptador = new adaptador_listView(getApplicationContext(), lista);
        listaDatos.setAdapter(miadaptador);

        listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    String temporada = listaTemporadas.get(0).getTemporadas_titulo();
                    Intent myIntent = new Intent(view.getContext(), Ver_temporada.class);
                    myIntent.putExtra("temporada", temporada);
                    startActivity(myIntent);
                }if(position == 1){
                    String temporada = listaTemporadas.get(1).getTemporadas_titulo();
                    Intent myIntent = new Intent(view.getContext(), Ver_temporada.class);
                    myIntent.putExtra("temporada", temporada);
                    startActivity(myIntent);
                }if(position == 2){
                    String temporada = listaTemporadas.get(2).getTemporadas_titulo();
                    Intent myIntent = new Intent(view.getContext(), Ver_temporada.class);
                    myIntent.putExtra("temporada", temporada);
                    startActivity(myIntent);
                }if(position == 3){
                    String temporada = listaTemporadas.get(3).getTemporadas_titulo();
                    Intent myIntent = new Intent(view.getContext(), Ver_temporada.class);
                    myIntent.putExtra("temporada", temporada);
                    startActivity(myIntent);
                }if(position == 4){
                    String temporada = listaTemporadas.get(4).getTemporadas_titulo();
                    Intent myIntent = new Intent(view.getContext(), Ver_temporada.class);
                    myIntent.putExtra("temporada", temporada);
                    startActivity(myIntent);
                }if(position == 5){
                    String temporada = listaTemporadas.get(5).getTemporadas_titulo();
                    Intent myIntent = new Intent(view.getContext(), Ver_temporada.class);
                    myIntent.putExtra("temporada", temporada);
                    startActivity(myIntent);
                }
            }
        });
    }
}