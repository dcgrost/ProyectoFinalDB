package com.example.alam.proyectofinaldb;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alam.proyectofinaldb.Entidades.Entidades_peliculas;
import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.util.ArrayList;

public class Ver_capitulo extends AppCompatActivity {

    TextView tv_titulo, tv_sinopsis, tv_genero, tv_idiomaO, tv_fechaE, tv_precio;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_capitulo);

        String capitulo = getIntent().getStringExtra("capitulo");

        tv_titulo = (TextView)findViewById(R.id.titulo);
        tv_sinopsis = (TextView)findViewById(R.id.sinopsis);
        tv_genero = (TextView)findViewById(R.id.genero);
        tv_idiomaO = (TextView)findViewById(R.id.idiomaO);
        tv_fechaE = (TextView)findViewById(R.id.fechaE);
        tv_precio = (TextView)findViewById(R.id.precio);
        img = (ImageView)findViewById(R.id.imageView);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Entidades_peliculas pelicula = null;

        String query = "select "+Data_utilities.CcampoId+", "+Data_utilities.CcampoTitulo+", "+Data_utilities.CcampoSinopsis+", "
                +Data_utilities.ScampoGenero+", "+Data_utilities.ScampoIdiomaOriginal+", "+Data_utilities.TcampoFechaEstreno+" from "
                +Data_utilities.tablaPeliculas+ " as "+Data_utilities.PcampoId+" inner join "+Data_utilities.tablaTempoaradas+" as "
                +Data_utilities.TcampoId+" on "+Data_utilities.CcampoTemporadasID+" = "+Data_utilities.TcampoId+" inner join "+
                Data_utilities.tablaSeries+" as "+Data_utilities.ScampoId+" on "+Data_utilities.TcampoSeriesID+" = "
                +Data_utilities.ScampoId+" where "+Data_utilities.CcampoId+" = '"+capitulo+"'";

        Cursor fila = db.rawQuery(query,null);
        fila.moveToFirst();

        tv_titulo.setText(fila.getString(0));
        tv_sinopsis.setText(fila.getString(1));
        tv_genero.setText(fila.getString(2));
        tv_idiomaO.setText(fila.getString(3));
        tv_fechaE.setText(fila.getString(4));
        tv_precio.setText(fila.getString(5));
        img.setImageResource(fila.getInt(6));
        fila.close();
    }
}
