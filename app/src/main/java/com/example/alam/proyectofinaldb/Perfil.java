package com.example.alam.proyectofinaldb;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

public class Perfil extends AppCompatActivity {

    TextView tv_nombre, tv_correo, tv_fechaN, tv_saldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tv_nombre = (TextView)findViewById(R.id.nombre);
        tv_correo = (TextView)findViewById(R.id.correo);
        tv_fechaN = (TextView)findViewById(R.id.fechaN);
        tv_saldo = (TextView)findViewById(R.id.saldo);

        String userId = getIntent().getStringExtra("userId");

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String nombre = userId;
        String[] parametro = {nombre};
        String[] campos = {Data_utilities.UcampoNombre, Data_utilities.UcampoCorreo, Data_utilities.UcampoFechaN, Data_utilities.UcampoSaldo};

        Cursor fila = db.query(Data_utilities.tablaUsuarios, campos, Data_utilities.UcampoId+ "=?", parametro, null, null, null);
        fila.moveToFirst();
        tv_nombre.setText(fila.getString(0));
        tv_correo.setText(fila.getString(1));
        tv_fechaN.setText(fila.getString(2));
        tv_saldo.setText(fila.getString(3));
        fila.close();
    }
    public void misPeliculas(View view){
        String userId = getIntent().getStringExtra("userId");
        Intent myIntent = new Intent(view.getContext(), Mis_peliculas.class);
        myIntent.putExtra("userId", userId);
        startActivity(myIntent);
    }
    public void misCapitulos(View view){
        String userId = getIntent().getStringExtra("userId");
        Intent myIntent = new Intent(view.getContext(), Mis_capitulos.class);
        myIntent.putExtra("userId", userId);
        startActivity(myIntent);
    }
}
