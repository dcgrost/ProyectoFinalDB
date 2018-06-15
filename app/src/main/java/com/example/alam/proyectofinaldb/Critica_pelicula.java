package com.example.alam.proyectofinaldb;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.util.Calendar;
import java.util.Date;

public class Critica_pelicula extends AppCompatActivity {

    EditText et_comentario;
    TextView tv_titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_critica_pelicula);

        et_comentario = (EditText)findViewById(R.id.critica_txt);
        tv_titulo = (TextView)findViewById(R.id.titulo);

        String nomPeli = getIntent().getStringExtra("nomPeli");

        tv_titulo.setText(nomPeli);
    }

    public void Criticar (View view){

        String userId = getIntent().getStringExtra("userId");
        String peliculaId = getIntent().getStringExtra("peliculaId");

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String comentario = et_comentario.getText().toString();

        if(comentario.isEmpty()){
            Toast.makeText(this, "Ingresa un comentario", Toast.LENGTH_SHORT).show();
        }else{

            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            month++;
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            String date = year+"-"+month+"-"+day;

            ContentValues alta = new ContentValues();
            alta.put(Data_utilities.CRcampoComentario, comentario);
            alta.put(Data_utilities.CRcampoFecha, date);
            alta.put(Data_utilities.CRcampoUsuariosID, userId);
            alta.put(Data_utilities.CRcampoPeliculasID, peliculaId);

            long x = db.insert(Data_utilities.tablaCriticas, Data_utilities.CRcampoId, alta);
            Toast.makeText(this, "Critica hecha"+x, Toast.LENGTH_SHORT).show();
            db.close();

            Intent myIntent = new Intent(view.getContext(), Ver_pelicula.class);
            myIntent.putExtra("peliculaId", peliculaId);
            myIntent.putExtra("userId", userId);
            startActivity(myIntent);
        }
    }
}
