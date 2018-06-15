package com.example.alam.proyectofinaldb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

public class Tipo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo);
        String userId = getIntent().getStringExtra("userId");
    }
    public void Peliculas (View view){
        Intent myIntent = new Intent(view.getContext(), Genero.class);
        String userId = getIntent().getStringExtra("userId");
        myIntent.putExtra("tipo", "Data_utilities.tablaPeliculas");
        myIntent.putExtra("userId", userId);
        startActivity(myIntent);
    }
    public void Series (View view){
        Intent myIntent = new Intent(view.getContext(), Genero.class);
        String userId = getIntent().getStringExtra("userId");
        myIntent.putExtra("tipo", "Data_utilities.tablaSeries");
        myIntent.putExtra("userId", userId);
        startActivity(myIntent);
    }
    public void Perfil (View view){
        Intent myIntent = new Intent(view.getContext(), Perfil.class);
        String userId = getIntent().getStringExtra("userId");
        myIntent.putExtra("userId", userId);
        startActivity(myIntent);
    }
}
