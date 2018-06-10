package com.example.alam.proyectofinaldb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Tipo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo);
    }
    public void Peliculas (View view){
        Intent myIntent = new Intent(view.getContext(), Genero.class);
        startActivity(myIntent);
    }
    public void Series (View view){
        Intent myIntent = new Intent(view.getContext(), Genero.class);
        startActivity(myIntent);
    }
}
