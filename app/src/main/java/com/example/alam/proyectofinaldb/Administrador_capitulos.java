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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alam.proyectofinaldb.Entidades.Entidades_series;
import com.example.alam.proyectofinaldb.Entidades.Entidades_temporadas;
import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Administrador_capitulos extends AppCompatActivity {

    EditText et_titulo, et_sinopsis, et_duracion, et_precio;
    TextView tv_temporadaid;
    ImageView iv_img;
    Spinner sp_temporadas;
    ArrayList<String> list_temporadas;
    ArrayList<Entidades_temporadas> temporadasLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_capitulos);

        et_titulo = (EditText)findViewById(R.id.titulo);
        et_sinopsis = (EditText)findViewById(R.id.sinopsis);
        et_duracion = (EditText)findViewById(R.id.duracion);
        et_precio = (EditText)findViewById(R.id.precio);
        sp_temporadas = (Spinner)findViewById(R.id.spinner);
        tv_temporadaid = (TextView)findViewById(R.id.temporadaid);
        iv_img = (ImageView)findViewById(R.id.imagenId);

        //Spinner temporadas
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        Entidades_temporadas temporada = null;
        temporadasLista = new ArrayList<Entidades_temporadas>();
        String queryt = "select " + Data_utilities.TcampoId+ ", " +Data_utilities.TcampoTitulo+ " from "+Data_utilities.tablaTempoaradas+"";

        Cursor cursor = db.rawQuery(queryt,null);

        while (cursor.moveToNext()){
            temporada = new Entidades_temporadas();
            temporada.setTemporadas_id(cursor.getInt(0));
            temporada.setTemporadas_titulo(cursor.getString(1));

            temporadasLista.add(temporada);
        }
        list_temporadas = new ArrayList<String>();
        list_temporadas.add("Seleccione una temporada");

        for (int i=0;i<temporadasLista.size();i++){
            list_temporadas.add(temporadasLista.get(i).getTemporadas_id(), temporadasLista.get(i).getTemporadas_titulo());
        }

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list_temporadas);

        sp_temporadas.setAdapter(adapter);
        //termina spinner serie

        sp_temporadas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String serie = String.valueOf(position);
                tv_temporadaid.setText(serie);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void Alta(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String titulo = et_titulo.getText().toString();
        String sinopsis = et_sinopsis.getText().toString();
        String duracion = et_duracion.getText().toString();
        String precio = et_precio.getText().toString();
        String temporadaid = tv_temporadaid.getText().toString();
        String imagen = iv_img.getDrawable().toString();

        if (titulo.isEmpty() && sinopsis.isEmpty() && duracion.isEmpty() && precio.isEmpty() && temporadaid.isEmpty()){
            Toast.makeText(this, "Ingresa todos los datos", Toast.LENGTH_SHORT).show();
        }
        if (sinopsis.isEmpty()){
            Toast.makeText(this, "Ingresa un titulo", Toast.LENGTH_SHORT).show();
        }
        if (duracion.isEmpty()){
            Toast.makeText(this, "Ingresa una duración", Toast.LENGTH_SHORT).show();
        }
        if (precio.isEmpty()){
            Toast.makeText(this, "Ingresa un precio", Toast.LENGTH_SHORT).show();
        }
        if (Integer.parseInt(temporadaid) < 1){
            Toast.makeText(this, "Selecciona una temporada", Toast.LENGTH_SHORT).show();
        }
        if (!titulo.isEmpty() && !sinopsis.isEmpty() && !duracion.isEmpty() && !precio.isEmpty() && Integer.parseInt(temporadaid) > 0){

            ContentValues alta = new ContentValues();
            alta.put(Data_utilities.CcampoTitulo, titulo);
            alta.put(Data_utilities.CcampoDuracion, duracion);
            alta.put(Data_utilities.CcampoPrecio, precio);
            alta.put(Data_utilities.CcampoSinopsis, sinopsis);
            alta.put(Data_utilities.CcampoTemporadasID, temporadaid);

            db.insert(Data_utilities.tablaCapitulos,Data_utilities.CcampoId,alta);
            Toast.makeText(this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
            db.close();

            et_titulo.setText("");
            et_sinopsis.setText("");
            et_duracion.setText("");
            et_precio.setText("");
            sp_temporadas.setSelection(0);
            iv_img.setImageResource(R.drawable.notfound);
        }
    }

    public void Busca(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String titulo = et_titulo.getText().toString();
        String[] parametro = {titulo};
        String[] campos = {Data_utilities.CcampoSinopsis, Data_utilities.CcampoDuracion, Data_utilities.CcampoPrecio, Data_utilities.CcampoTemporadasID, Data_utilities.CcampoImg};

        if(!titulo.isEmpty()){
            try{
                Cursor fila = db.query(Data_utilities.tablaCapitulos, campos, Data_utilities.CcampoTitulo+ "=?", parametro, null, null, null);
                fila.moveToFirst();
                et_sinopsis.setText(fila.getString(0));
                et_duracion.setText(fila.getString(1));
                et_precio.setText(fila.getString(2));
                sp_temporadas.setSelection(fila.getInt(3));
                iv_img.setImageResource(fila.getInt(4));
                fila.close();
            }catch (Exception e){
                Toast.makeText(this, "La serie no existe", Toast.LENGTH_SHORT).show();

                et_titulo.setText("");
                et_sinopsis.setText("");
                et_duracion.setText("");
                et_precio.setText("");
                sp_temporadas.setSelection(0);
                iv_img.setImageResource(R.drawable.notfound);
            }
        }else{
            Toast.makeText(this, "Ingresa un título", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpia(View view){
        et_titulo.setText("");
        et_sinopsis.setText("");
        et_duracion.setText("");
        et_precio.setText("");
        sp_temporadas.setSelection(0);
        iv_img.setImageResource(R.drawable.notfound);
    }

    public void Actualiza(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String titulo = et_titulo.getText().toString();
        String sinopsis = et_sinopsis.getText().toString();
        String duracion = et_duracion.getText().toString();
        String precio = et_precio.getText().toString();
        String temporadaid = tv_temporadaid.getText().toString();
        String[] parametro = {titulo};

        ContentValues actualiza = new ContentValues();
        actualiza.put(Data_utilities.CcampoTitulo, titulo);
        actualiza.put(Data_utilities.CcampoDuracion, duracion);
        actualiza.put(Data_utilities.CcampoPrecio, precio);
        actualiza.put(Data_utilities.CcampoSinopsis, sinopsis);
        actualiza.put(Data_utilities.CcampoTemporadasID, temporadaid);

        db.update(Data_utilities.tablaCapitulos, actualiza, Data_utilities.CcampoTitulo+ "=?",parametro);
        Toast.makeText(this, "Actualización exitosa", Toast.LENGTH_SHORT).show();
        db.close();

        et_titulo.setText("");
        et_sinopsis.setText("");
        et_duracion.setText("");
        et_precio.setText("");
        sp_temporadas.setSelection(0);
        iv_img.setImageResource(R.drawable.notfound);
    }

    public void Baja(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String titulo = et_titulo.getText().toString();
        String[] parametro = {titulo};

        db.delete(Data_utilities.tablaCapitulos, Data_utilities.CcampoTitulo+ "=?",parametro);
        Toast.makeText(this, "Eliminación exitosa", Toast.LENGTH_SHORT).show();
        db.close();

        et_titulo.setText("");
        et_sinopsis.setText("");
        et_duracion.setText("");
        et_precio.setText("");
        sp_temporadas.setSelection(0);
        iv_img.setImageResource(R.drawable.notfound);
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
