package com.example.alam.proyectofinaldb;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alam.proyectofinaldb.Entidades.Entidades_capitulos;
import com.example.alam.proyectofinaldb.Entidades.Entidades_peliculas;
import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.util.ArrayList;

public class Ver_capitulo extends AppCompatActivity {

    TextView tv_titulo, tv_sinopsis, tv_genero, tv_fechaE, tv_precio, tv_serie, tv_temporada;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_capitulo);

        String capitulo = getIntent().getStringExtra("capitulo");

        tv_titulo = (TextView)findViewById(R.id.titulo);
        tv_sinopsis = (TextView)findViewById(R.id.sinopsis);
        tv_genero = (TextView)findViewById(R.id.genero);
        tv_serie = (TextView)findViewById(R.id.serie);
        tv_temporada = (TextView)findViewById(R.id.temporada);
        tv_fechaE = (TextView)findViewById(R.id.fechaE);
        tv_precio = (TextView)findViewById(R.id.precio);
        img = (ImageView)findViewById(R.id.imageView);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Entidades_capitulos capituloM = null;

        String query = "select "+Data_utilities.CcampoTitulo+", "+Data_utilities.CcampoSinopsis+", "+Data_utilities.CcampoPrecio+", "+Data_utilities.CcampoImg+", "
                +Data_utilities.ScampoGenero+", "+Data_utilities.ScampoTitulo+", "+Data_utilities.TcampoTitulo+", "+Data_utilities.TcampoFechaEstreno+" from "+Data_utilities.tablaCapitulos+" inner join "
                +Data_utilities.tablaTempoaradas+" on "+Data_utilities.TcampoId+" = "+Data_utilities.CcampoTemporadasID+" inner join "
                +Data_utilities.tablaSeries+" on "+Data_utilities.ScampoId+" = "+Data_utilities.TcampoId+" where "+Data_utilities.CcampoId+" like '"+capitulo+"'";


        Cursor fila = db.rawQuery(query,null);
        fila.moveToFirst();

        tv_titulo.setText(fila.getString(0));
        tv_sinopsis.setText(fila.getString(1));
        tv_precio.setText(fila.getString(2));
        img.setImageResource(fila.getInt(3));
        tv_genero.setText(fila.getString(4));
        tv_serie.setText(fila.getString(5));
        tv_temporada.setText(fila.getString(6));
        tv_fechaE.setText(fila.getString(7));
        fila.close();
    }
}
