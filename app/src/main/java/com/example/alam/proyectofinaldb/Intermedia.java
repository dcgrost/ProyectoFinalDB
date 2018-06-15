package com.example.alam.proyectofinaldb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

public class Intermedia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermedia);
    }
    public void Todo (View view){
        Intent myIntent = new Intent(view.getContext(), Todas_peliculas.class);
        String userId = getIntent().getStringExtra("userId");
        String tipo = getIntent().getStringExtra("tipo");
        myIntent.putExtra("userId", userId);
        myIntent.putExtra("tipo", tipo);
        startActivity(myIntent);
    }
    public void Genero (View view){
        Intent myIntent = new Intent(view.getContext(), Genero.class);
        String userId = getIntent().getStringExtra("userId");
        String tipo = getIntent().getStringExtra("tipo");
        myIntent.putExtra("tipo", tipo);
        myIntent.putExtra("userId", userId);
        startActivity(myIntent);
    }
    public void Perfil (View view){
        Intent myIntent = new Intent(view.getContext(), Perfil.class);
        String userId = getIntent().getStringExtra("userId");
        myIntent.putExtra("userId", userId);
        startActivity(myIntent);
    }
    public void Volver(View view){
        Intent myIntent = new Intent(view.getContext(), Tipo.class);
        String userId = getIntent().getStringExtra("userId");
        myIntent.putExtra("userId", userId);
        startActivity(myIntent);
    }
}
