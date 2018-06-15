package com.example.alam.proyectofinaldb;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alam.proyectofinaldb.Entidades.Entidades_criticas;
import com.example.alam.proyectofinaldb.Entidades.Entidades_peliculas;
import com.example.alam.proyectofinaldb.Entidades.Entidades_temporadas;
import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Ver_pelicula extends AppCompatActivity {

    TextView tv_titulo, tv_sinopsis, tv_genero, tv_idiomaO, tv_fechaE, tv_precio;
    ImageView img;

    ListView listaDatos;
    ArrayList<datos_listView3> lista;
    ArrayList<Entidades_criticas> listaCriticas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pelicula);
        String userId = getIntent().getStringExtra("userId");
        String titulo = getIntent().getStringExtra("titulo");
        String peiluclaId = getIntent().getStringExtra("peiluclaId");

        tv_titulo = (TextView)findViewById(R.id.titulo);
        tv_sinopsis = (TextView)findViewById(R.id.sinopsis);
        tv_genero = (TextView)findViewById(R.id.genero);
        tv_idiomaO = (TextView)findViewById(R.id.idiomaO);
        tv_fechaE = (TextView)findViewById(R.id.fechaE);
        tv_precio = (TextView)findViewById(R.id.precio);
        img = (ImageView)findViewById(R.id.imageView);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String nombre = titulo;
        String[] parametro = {nombre};
        String[] campos = {Data_utilities.PcampoTitulo, Data_utilities.PcampoSinopsis, Data_utilities.PcampoGenero, Data_utilities.PcampoIdiomaOriginal, Data_utilities.PcampoFechaEstreno, Data_utilities.PcampoPrecio, Data_utilities.PcampoImg};

        Cursor fila2 = db.query(Data_utilities.tablaPeliculas, campos, Data_utilities.PcampoTitulo + "=?", parametro, null, null, null);
        fila2.moveToFirst();
        tv_titulo.setText(fila2.getString(0));
        tv_sinopsis.setText(fila2.getString(1));
        tv_genero.setText(fila2.getString(2));
        tv_idiomaO.setText(fila2.getString(3));
        tv_fechaE.setText(fila2.getString(4));
        tv_precio.setText(fila2.getString(5));
        img.setImageResource(fila2.getInt(6));
        fila2.close();

        //Llenado de list view criticas

        listaDatos = (ListView)findViewById(R.id.listView);

        Entidades_criticas critica = null;

        listaCriticas= new ArrayList<Entidades_criticas>();
        String query = "select " +Data_utilities.CRcampoId+", "+Data_utilities.UcampoNombre+", "+Data_utilities.CRcampoFecha+", "+ Data_utilities.CRcampoComentario+" from "+Data_utilities.tablaCriticas
                +" inner join " +Data_utilities.tablaUsuarios+ " on "+Data_utilities.UcampoId+" = "+Data_utilities.CRcampoUsuariosID
                +" inner join " +Data_utilities.tablaPeliculas+ " on "+Data_utilities.PcampoId+" = "+Data_utilities.CRcampoPeliculasID+" where " +Data_utilities.PcampoTitulo+ " = '" +titulo+"'";

        Cursor fila = db.rawQuery(query,null);

        while(fila.moveToNext()){
            critica = new Entidades_criticas();
            critica.setCriticas_id(fila.getInt(0));
            critica.setCriticas_usuario_id(fila.getString(1));
            critica.setCriticas_fecha(fila.getString(2));
            critica.setCriticas_comentario(fila.getString(3));

            listaCriticas.add(critica);
        }

        lista = new ArrayList<datos_listView3>();

        for (int i=0;i<listaCriticas.size();i++){
            lista.add(new datos_listView3(listaCriticas.get(i).getCriticas_id(),listaCriticas.get(i).getCriticas_usuario(),listaCriticas.get(i).getCriticas_fecha(),listaCriticas.get(i).getCriticas_comentario()));
        }

        adaptador_listView3 miadaptador = new adaptador_listView3(getApplicationContext(), lista);
        listaDatos.setAdapter(miadaptador);
    }
}
