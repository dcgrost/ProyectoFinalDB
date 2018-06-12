package com.example.alam.proyectofinaldb;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Administrador_peliculas extends AppCompatActivity {

    EditText et_titulo, et_genero, et_sinopsis, et_idiomaO, et_fechaE, et_precio;
    ImageView iv_img;

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
        iv_img = (ImageView)findViewById(R.id.imagenId);
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

        int imagen = R.drawable.notfound;

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
            alta.put(Data_utilities.PcampoImg, imagen);

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

    public void Busca(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String titulo = et_titulo.getText().toString();
        String[] parametro = {titulo};
        String[] campos = {Data_utilities.PcampoGenero, Data_utilities.PcampoSinopsis, Data_utilities.PcampoIdiomaOriginal, Data_utilities.PcampoFechaEstreno, Data_utilities.PcampoPrecio};

        if(!titulo.isEmpty()){
            try{
                Cursor fila = db.query(Data_utilities.tablaPeliculas, campos, Data_utilities.PcampoTitulo+ "=?", parametro, null, null, null);
                fila.moveToFirst();
                et_genero.setText(fila.getString(0));
                et_sinopsis.setText(fila.getString(1));
                et_idiomaO.setText(fila.getString(2));
                et_fechaE.setText(fila.getString(3));
                et_precio.setText(fila.getString(4));
                fila.close();
            }catch (Exception e){
                Toast.makeText(this, "La pelicula no existe", Toast.LENGTH_SHORT).show();

                et_titulo.setText("");
                et_genero.setText("");
                et_sinopsis.setText("");
                et_idiomaO.setText("");
                et_fechaE.setText("");
                et_precio.setText("");
            }
        }else{
            Toast.makeText(this, "Ingresa un nombre", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpia(View view){
        et_titulo.setText("");
        et_genero.setText("");
        et_sinopsis.setText("");
        et_idiomaO.setText("");
        et_fechaE.setText("");
        et_precio.setText("");
    }

    public void Actualiza(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String titulo = et_titulo.getText().toString();
        String genero= et_genero.getText().toString();
        String sinopsis = et_sinopsis.getText().toString();
        String idiomaO = et_idiomaO.getText().toString();
        String fechaE = et_fechaE.getText().toString();
        String precio = et_precio.getText().toString();
        String[] parametro = {titulo};

        ContentValues actualiza = new ContentValues();
        actualiza.put(Data_utilities.PcampoTitulo, titulo);
        actualiza.put(Data_utilities.PcampoGenero, genero);
        actualiza.put(Data_utilities.PcampoSinopsis, sinopsis);
        actualiza.put(Data_utilities.PcampoIdiomaOriginal, idiomaO);
        actualiza.put(Data_utilities.PcampoFechaEstreno, fechaE);
        actualiza.put(Data_utilities.PcampoPrecio, precio);

        db.update(Data_utilities.tablaPeliculas, actualiza, Data_utilities.PcampoTitulo+ "=?",parametro);
        Toast.makeText(this, "Actualizacion exitosa", Toast.LENGTH_SHORT).show();
        db.close();

        et_titulo.setText("");
        et_genero.setText("");
        et_sinopsis.setText("");
        et_idiomaO.setText("");
        et_fechaE.setText("");
        et_precio.setText("");
    }

    public void Baja(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String titulo = et_titulo.getText().toString();
        String[] parametro = {titulo};

        db.delete(Data_utilities.tablaPeliculas, Data_utilities.PcampoTitulo+ "=?",parametro);
        Toast.makeText(this, "Eliminación exitosa", Toast.LENGTH_SHORT).show();
        db.close();

        et_titulo.setText("");
        et_genero.setText("");
        et_sinopsis.setText("");
        et_idiomaO.setText("");
        et_fechaE.setText("");
        et_precio.setText("");
    }

    private boolean validarFecha(String fecha) {
        String patron = "^(19[0-9][0-9]|20[0-2][0-9])-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[01])";
        Pattern pattern = Pattern.compile(patron);
        Matcher match = pattern.matcher(fecha);
        return match.matches();
    }

    public void Subir(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Seleccione una imágen"),10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Uri path = data.getData();
            iv_img.setImageURI(path);
        }
    }
}
