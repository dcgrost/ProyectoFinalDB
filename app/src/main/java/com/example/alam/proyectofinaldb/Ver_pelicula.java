package com.example.alam.proyectofinaldb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Ver_pelicula extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pelicula);

        String titulo = getIntent().getStringExtra("titulo");
    }
}
