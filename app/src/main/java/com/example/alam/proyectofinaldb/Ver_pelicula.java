package com.example.alam.proyectofinaldb;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alam.proyectofinaldb.Entidades.Entidades_peliculas;
import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Ver_pelicula extends AppCompatActivity {

    TextView tv_titulo, tv_sinopsis, tv_genero, tv_idiomaO, tv_fechaE, tv_precio;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pelicula);
        String userId = getIntent().getStringExtra("userId");

        String titulo = getIntent().getStringExtra("titulo");

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

        Cursor fila = db.query(Data_utilities.tablaPeliculas, campos, Data_utilities.PcampoTitulo + "=?", parametro, null, null, null);
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
