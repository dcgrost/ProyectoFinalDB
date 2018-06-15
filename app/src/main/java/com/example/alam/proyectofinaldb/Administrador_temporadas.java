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

public class Administrador_temporadas extends AppCompatActivity {

    EditText et_titulo, et_fechaP, et_fechaE;
    TextView tv_serieid;
    ImageView iv_img;
    Spinner sp_series;
    ArrayList<String> list_series;
    ArrayList<Entidades_series> seriesLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_temporadas);

        et_titulo = (EditText)findViewById(R.id.titulo);
        et_fechaE = (EditText)findViewById(R.id.fechaE);
        et_fechaP = (EditText)findViewById(R.id.fechaP);
        iv_img = (ImageView)findViewById(R.id.imagenId);
        sp_series = (Spinner)findViewById(R.id.spinner);
        tv_serieid = (TextView)findViewById(R.id.serieid);

        //Spinner series
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        Entidades_series serie = null;
        seriesLista = new ArrayList<Entidades_series>();
        String queryt = "select " + Data_utilities.ScampoId+ ", " +Data_utilities.ScampoTitulo+ " from "+Data_utilities.tablaSeries+"";

        Cursor cursor = db.rawQuery(queryt,null);

        while (cursor.moveToNext()){
            serie = new Entidades_series();
            serie.setSeries_id(cursor.getInt(0));
            serie.setSeries_titulo(cursor.getString(1));

            seriesLista.add(serie);
        }

        list_series = new ArrayList<String>();
        list_series.add("Seleccione una serie");

        for (int i=0;i<seriesLista.size();i++){
            list_series.add(seriesLista.get(i).getSeries_id(), seriesLista.get(i).getSeries_titulo());
        }

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list_series);

        sp_series.setAdapter(adapter);
        //termina spinner serie

        sp_series.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String serie = String.valueOf(position);
                tv_serieid.setText(serie);
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
        String fechaE = et_fechaE.getText().toString();
        String fechaP = et_fechaP.getText().toString();
        String serieid = tv_serieid.getText().toString();
        String imagen = iv_img.getDrawable().toString();

        if (titulo.isEmpty() && fechaE.isEmpty() && fechaP.isEmpty() && serieid.isEmpty()){
            Toast.makeText(this, "Ingresa todos los datos", Toast.LENGTH_SHORT).show();
        }
        if (titulo.isEmpty()){
            Toast.makeText(this, "Ingresa un titulo", Toast.LENGTH_SHORT).show();
        }
        if (fechaE.isEmpty()){
            Toast.makeText(this, "Ingresa una fecha de estreno", Toast.LENGTH_SHORT).show();
        }
        if (!fechaE.isEmpty() && !validarFecha(fechaE)){
            Toast.makeText(this, "Ingresa una fecha con el formato AAAA-MM-DD", Toast.LENGTH_SHORT).show();
        }
        if (fechaP.isEmpty()){
            Toast.makeText(this, "Ingresa una fecha de producción", Toast.LENGTH_SHORT).show();
        }
        if (!fechaP.isEmpty() && !validarFecha(fechaP)){
            Toast.makeText(this, "Ingresa una fecha con el formato AAAA-MM-DD", Toast.LENGTH_SHORT).show();
        }
        if (Integer.parseInt(serieid) < 1){
            Toast.makeText(this, "Selecciona una serie", Toast.LENGTH_SHORT).show();
        }
        if (!titulo.isEmpty() && !fechaE.isEmpty() && !fechaP.isEmpty() && validarFecha(fechaE) && validarFecha(fechaP) && Integer.parseInt(serieid) > 0){

            ContentValues alta = new ContentValues();
            alta.put(Data_utilities.TcampoTitulo, titulo);
            alta.put(Data_utilities.TcampoFechaEstreno, fechaE);
            alta.put(Data_utilities.TcampoFechaProduccion, fechaP);
            alta.put(Data_utilities.TcampoSeriesID, serieid);

            db.insert(Data_utilities.tablaTempoaradas,Data_utilities.TcampoId,alta);
            Toast.makeText(this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
            db.close();

            et_titulo.setText("");
            et_fechaE.setText("");
            et_fechaP.setText("");
            sp_series.setSelection(0);
            iv_img.setImageResource(R.drawable.notfound);
        }
    }

    public void Busca(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String titulo = et_titulo.getText().toString();
        String[] parametro = {titulo};
        String[] campos = {Data_utilities.TcampoFechaEstreno, Data_utilities.TcampoFechaProduccion, Data_utilities.TcampoSeriesID, Data_utilities.TcampoImg};

        if(!titulo.isEmpty()){
            try{
                Cursor fila = db.query(Data_utilities.tablaTempoaradas, campos, Data_utilities.TcampoTitulo+ "=?", parametro, null, null, null);
                fila.moveToFirst();
                et_fechaE.setText(fila.getString(0));
                et_fechaP.setText(fila.getString(1));
                sp_series.setSelection(fila.getInt(2));
                iv_img.setImageResource(fila.getInt(3));
                fila.close();
            }catch (Exception e){
                Toast.makeText(this, "La temporada no existe", Toast.LENGTH_SHORT).show();

                et_titulo.setText("");
                et_fechaE.setText("");
                et_fechaP.setText("");
                sp_series.setSelection(0);
                iv_img.setImageResource(R.drawable.notfound);
            }
        }else{
            Toast.makeText(this, "Ingresa un título", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpia(View view){
            et_titulo.setText("");
            et_fechaE.setText("");
            et_fechaP.setText("");
            sp_series.setSelection(0);
            iv_img.setImageResource(R.drawable.notfound);
    }

    public void Actualiza(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String titulo = et_titulo.getText().toString();
        String fechaE = et_fechaE.getText().toString();
        String fechaP = et_fechaP.getText().toString();
        String serieid = tv_serieid.getText().toString();
        String[] parametro = {titulo};

        ContentValues actualiza = new ContentValues();
        actualiza.put(Data_utilities.TcampoTitulo, titulo);
        actualiza.put(Data_utilities.TcampoFechaEstreno, fechaE);
        actualiza.put(Data_utilities.TcampoFechaProduccion, fechaP);
        actualiza.put(Data_utilities.TcampoSeriesID, serieid);

        db.update(Data_utilities.tablaTempoaradas, actualiza, Data_utilities.TcampoTitulo+ "=?",parametro);
        Toast.makeText(this, "Actualizacion exitosa", Toast.LENGTH_SHORT).show();
        db.close();

        et_titulo.setText("");
        et_fechaE.setText("");
        et_fechaP.setText("");
        sp_series.setSelection(0);
        iv_img.setImageResource(R.drawable.notfound);
    }

    public void Baja(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String titulo = et_titulo.getText().toString();
        String[] parametro = {titulo};

        db.delete(Data_utilities.tablaTempoaradas, Data_utilities.TcampoTitulo+ "=?",parametro);
        Toast.makeText(this, "Eliminación exitosa", Toast.LENGTH_SHORT).show();
        db.close();

        et_titulo.setText("");
        et_fechaE.setText("");
        et_fechaP.setText("");
        sp_series.setSelection(0);
        iv_img.setImageResource(R.drawable.notfound);
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
