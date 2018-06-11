package com.example.alam.proyectofinaldb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

public class Peliculas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);

        String tipo = getIntent().getStringExtra("tipo");
        String genero = getIntent().getStringExtra("genero");

        String query = "select "+Data_utilities.PcampoImg+", "+Data_utilities.PcampoTitulo+", "+Data_utilities.PcampoSinopsis+" from "+tipo+" where "+Data_utilities.PcampoGenero+" ='"+genero+"'";
    }
}
