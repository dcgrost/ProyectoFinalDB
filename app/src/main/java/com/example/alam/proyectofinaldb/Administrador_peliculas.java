package com.example.alam.proyectofinaldb;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Administrador_peliculas extends AppCompatActivity {

    EditText et_titulo, et_genero, et_sinopsis, et_idiomaO, et_fechaE, et_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_peliculas);

        et_titulo = (EditText)findViewById(R.id.titulo);
        et_genero = (EditText)findViewById(R.id.genero);
        et_sinopsis = (EditText)findViewById(R.id.sinopsis);
        et_idiomaO = (EditText)findViewById(R.id.idiomaO);
        et_fechaE = (EditText)findViewById(R.id.fechaE);
        et_precio = (EditText)findViewById(R.id.precio);
    }

    public void Alta(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String titulo = et_titulo.getText().toString();
        String genero= et_genero.getText().toString();
        String sinopsis = et_sinopsis.getText().toString();
        String idiomaO = et_idiomaO.getText().toString();
        String fechaE = et_fechaE.getText().toString();
        String precio = et_precio.getText().toString();

        if (titulo.isEmpty() && genero.isEmpty() && sinopsis.isEmpty() && idiomaO.isEmpty() && fechaE.isEmpty() && precio.isEmpty()){
            Toast.makeText(this, "Ingresa todos los datos", Toast.LENGTH_SHORT).show();
        }
        if (titulo.isEmpty()){
            Toast.makeText(this, "Ingresa un titulo", Toast.LENGTH_SHORT).show();
        }
        if (genero.isEmpty()){
            Toast.makeText(this, "Ingresa un género", Toast.LENGTH_SHORT).show();
        }
        if (sinopsis.isEmpty()){
            Toast.makeText(this, "Ingresa una sinopsis", Toast.LENGTH_SHORT).show();
        }
        if (idiomaO.isEmpty()){
            Toast.makeText(this, "Ingresa un idioma original", Toast.LENGTH_SHORT).show();
        }
        if (fechaE.isEmpty()){
            Toast.makeText(this, "Ingresa una fecha de estreno", Toast.LENGTH_SHORT).show();
        }
        if (precio.isEmpty()){
            Toast.makeText(this, "Ingresa un precio", Toast.LENGTH_SHORT).show();
        }
        if (!fechaE.isEmpty() && !validarFecha(fechaE)){
            Toast.makeText(this, "Ingresa una fecha con el formato AAAA-MM-DD", Toast.LENGTH_SHORT).show();
        }
        if (!titulo.isEmpty() && !genero.isEmpty() && !sinopsis.isEmpty() && !idiomaO.isEmpty() && !fechaE.isEmpty() && !precio.isEmpty() && validarFecha(fechaE)){

            ContentValues alta = new ContentValues();
            alta.put(Data_utilities.PcampoTitulo, titulo);
            alta.put(Data_utilities.PcampoGenero, genero);
            alta.put(Data_utilities.PcampoSinopsis, sinopsis);
            alta.put(Data_utilities.PcampoIdiomaOriginal, idiomaO);
            alta.put(Data_utilities.PcampoFechaEstreno, fechaE);
            alta.put(Data_utilities.PcampoPrecio, precio);

            db.insert(Data_utilities.tablaPeliculas, Data_utilities.PcampoId, alta);
            Toast.makeText(this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
            db.close();

            et_titulo.setText("");
            et_genero.setText("");
            et_sinopsis.setText("");
            et_idiomaO.setText("");
            et_fechaE.setText("");
            et_precio.setText("");
        }
    }

    private boolean validarFecha(String fecha) {
        String patron = "^(19[0-9][0-9]|20[0-2][0-9])-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[01])";
        Pattern pattern = Pattern.compile(patron);
        Matcher match = pattern.matcher(fecha);
        return match.matches();
    }
}
