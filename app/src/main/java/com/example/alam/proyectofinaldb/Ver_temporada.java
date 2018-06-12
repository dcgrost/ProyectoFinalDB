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

import com.example.alam.proyectofinaldb.Entidades.Entidades_capitulos;
import com.example.alam.proyectofinaldb.Entidades.Entidades_temporadas;
import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.util.ArrayList;

public class Ver_temporada extends AppCompatActivity {

    ListView listaDatos;
    ArrayList<datos_listView> lista;
    ArrayList<Entidades_capitulos> listaCapitulos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_temporada);

        String temporada = getIntent().getStringExtra("temporada");

        listaDatos = (ListView)findViewById(R.id.listView);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Entidades_capitulos capitulo = null;
        listaCapitulos = new ArrayList<Entidades_capitulos>();

        Toast.makeText(this, "el ID seleccionado es: "+temporada, Toast.LENGTH_SHORT).show();

        String query = "select "+ Data_utilities.CcampoId+", "+Data_utilities.CcampoTitulo+", "+Data_utilities.CcampoSinopsis+", "+Data_utilities.CcampoImg+" from "+Data_utilities.tablaCapitulos+" inner join "+Data_utilities.tablaTempoaradas+" on "+Data_utilities.CcampoId+" = "+Data_utilities.CcampoTemporadasID+" where "+Data_utilities.ScampoTitulo+" like '"+temporada+"'";

        Cursor fila = db.rawQuery(query,null);

        while(fila.moveToNext()){
            capitulo = new Entidades_capitulos();
            capitulo.setCapitulos_id(fila.getInt(0));
            capitulo.setCapitulos_titulo(fila.getString(1));
            capitulo.setCapitulos_temporadas_id(fila.getInt(2));
            capitulo.setCapitulos_imagen(fila.getInt(3));

            listaCapitulos.add(capitulo);
        }

        lista = new ArrayList<datos_listView>();

        for (int i=0;i<listaCapitulos.size();i++){
            lista.add(new datos_listView(listaCapitulos.get(i).getCapitulos_id(), listaCapitulos.get(i).getCapitulos_titulo(), listaCapitulos.get(i).getCapitulos_sinopsis(), listaCapitulos.get(i).getCapitulos_imagen()));
        }

        adaptador_listView miadaptador = new adaptador_listView(getApplicationContext(), lista);
        listaDatos.setAdapter(miadaptador);

        listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    int capitulo = listaCapitulos.get(0).getCapitulos_id();
                    Intent myIntent = new Intent(view.getContext(), Ver_capitulo.class);
                    myIntent.putExtra("capitulo", capitulo);
                    startActivity(myIntent);
                }if(position == 1){
                    int capitulo = listaCapitulos.get(1).getCapitulos_id();
                    Intent myIntent = new Intent(view.getContext(), Ver_capitulo.class);
                    myIntent.putExtra("capitulo", capitulo);
                    startActivity(myIntent);
                }if(position == 2){
                    int capitulo = listaCapitulos.get(2).getCapitulos_id();
                    Intent myIntent = new Intent(view.getContext(), Ver_capitulo.class);
                    myIntent.putExtra("capitulo", capitulo);
                    startActivity(myIntent);
                }if(position == 3){
                    int capitulo = listaCapitulos.get(3).getCapitulos_id();
                    Intent myIntent = new Intent(view.getContext(), Ver_capitulo.class);
                    myIntent.putExtra("capitulo", capitulo);
                    startActivity(myIntent);
                }if(position == 4){
                    int capitulo = listaCapitulos.get(4).getCapitulos_id();
                    Intent myIntent = new Intent(view.getContext(), Ver_capitulo.class);
                    myIntent.putExtra("capitulo", capitulo);
                    startActivity(myIntent);
                }if(position == 5){
                    int capitulo = listaCapitulos.get(5).getCapitulos_id();
                    Intent myIntent = new Intent(view.getContext(), Ver_capitulo.class);
                    myIntent.putExtra("capitulo", capitulo);
                    startActivity(myIntent);
                }
            }
        });
    }
}