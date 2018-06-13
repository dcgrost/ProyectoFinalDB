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
import com.example.alam.proyectofinaldb.Entidades.Entidades_series;
import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.util.ArrayList;

public class Series extends AppCompatActivity {

    ListView listaDatos;
    ArrayList<datos_listView> lista;
    ArrayList<Entidades_series> listaSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);

        String genero = getIntent().getStringExtra("genero");

        listaDatos = (ListView)findViewById(R.id.listView);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Entidades_series serie = null;
        listaSeries = new ArrayList<Entidades_series>();

        String query = "select "+ Data_utilities.ScampoId+", "+Data_utilities.ScampoTitulo+", "+Data_utilities.ScampoSinopsis+", "+Data_utilities.ScampoImg+" from "+Data_utilities.tablaSeries
                +" where "+Data_utilities.ScampoGenero+" like '"+genero+"'";

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
                    int serie = listaSeries.get(position).getSeries_id();
                    Intent myIntent = new Intent(view.getContext(), Ver_temporada.class);
                    myIntent.putExtra("serie", serie);
                    startActivity(myIntent);
            }
        });
    }
}

