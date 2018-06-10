package com.example.alam.proyectofinaldb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

public class Tipo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo);
    }
    public void Peliculas (View view){
        Intent myIntent = new Intent(view.getContext(), Genero.class);
        myIntent.putExtra("tipo", "Data_utilities.tablaPeliculas");
        startActivity(myIntent);
    }
    public void Series (View view){
        Intent myIntent = new Intent(view.getContext(), Genero.class);
        myIntent.putExtra("tipo", "Data_utilities.tablaSeries");
        startActivity(myIntent);
    }
}
