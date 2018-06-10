package com.example.alam.proyectofinaldb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Administrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
    }

    public void Usuarios (View view){
        Intent myIntent = new Intent(view.getContext(), Administrador_usuarios.class);
        startActivity(myIntent);
    }
    public void Peliculas (View view){
        Intent myIntent = new Intent(view.getContext(), Administrador_peliculas.class);
        startActivity(myIntent);
    }
    public void Series (View view){
        Intent myIntent = new Intent(view.getContext(), Administrador_series.class);
        startActivity(myIntent);
    }
}
