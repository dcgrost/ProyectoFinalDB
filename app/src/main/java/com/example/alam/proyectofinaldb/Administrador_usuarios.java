package com.example.alam.proyectofinaldb;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Administrador_usuarios extends AppCompatActivity {

    EditText et_nombre, et_correo, et_fechaN, et_contra, et_saldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_usuarios);

        et_nombre = (EditText)findViewById(R.id.nombre);
        et_correo = (EditText)findViewById(R.id.email);
        et_fechaN = (EditText)findViewById(R.id.fechaN);
        et_contra = (EditText)findViewById(R.id.password);
        et_saldo = (EditText)findViewById(R.id.saldo);
    }

    public void Alta(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String nombre = et_nombre.getText().toString();
        String fechaN = et_fechaN.getText().toString();
        String correo = et_correo.getText().toString();
        String contra = et_contra.getText().toString();
        String saldo = et_saldo.getText().toString();

        if (nombre.length() == 0 && fechaN.length() == 0 && correo.length() == 0 && contra.length() == 0){
            Toast.makeText(this, "Ingresa datos", Toast.LENGTH_SHORT).show();
        }
        if (correo.length() == 0){
            Toast.makeText(this, "Ingresa una correo electrónico", Toast.LENGTH_SHORT).show();
        }
        if (contra.length() == 0){
            Toast.makeText(this, "Ingresa una contraseña", Toast.LENGTH_SHORT).show();
        }
        if (nombre.length() == 0){
            Toast.makeText(this, "Ingresa un nombre", Toast.LENGTH_SHORT).show();
        }
        if (fechaN.length() == 0){
            Toast.makeText(this, "Ingresa fecha de nacimiento", Toast.LENGTH_SHORT).show();
        }
        if (nombre.length() != 0 && fechaN.length() != 0 && correo.length() != 0 && contra.length() !=0 && !validarEmail(correo)){
            Toast.makeText(this, "Ingresa un correo electrónico válido", Toast.LENGTH_SHORT).show();
        }
        if (nombre.length() != 0 && fechaN.length() != 0 && validarEmail(correo) && correo.length() != 0 && contra.length() !=0 && !validarContra(contra)){
            Toast.makeText(this, "La contraseña debe contar con al menos 1\n" +
                    "número, una letra mayúscula y mínimo 6 caracteres", Toast.LENGTH_LONG).show();
        }
        if (nombre.length() != 0 && fechaN.length() != 0 && validarEmail(correo) && correo.length() != 0 && contra.length() !=0 && validarContra(contra) && !validarFecha(fechaN)){
            Toast.makeText(this, "Ingresa una fecha con el formato AAAA-MM-DD", Toast.LENGTH_SHORT).show();
        }
        if (nombre.length() != 0 && fechaN.length() != 0 && correo.length() != 0 && contra.length() !=0 && validarContra(contra) && validarEmail(correo) && validarFecha(fechaN)){

            ContentValues alta = new ContentValues();
            alta.put(Data_utilities.UcampoNombre, nombre);
            alta.put(Data_utilities.UcampoFechaN, fechaN);
            alta.put(Data_utilities.UcampoCorreo, correo);
            alta.put(Data_utilities.UcampoContra, contra);
            alta.put(Data_utilities.UcampoSaldo, saldo);

            db.insert(Data_utilities.tablaUsuarios, Data_utilities.UcampoId, alta);
            Toast.makeText(this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
            db.close();

            et_nombre.setText("");
            et_fechaN.setText("");
            et_correo.setText("");
            et_contra.setText("");
            et_saldo.setText("");
        }
    }

    public void Busca(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String nombre = et_nombre.getText().toString();
        String[] parametro = {nombre};
        String[] campos = {Data_utilities.UcampoCorreo, Data_utilities.UcampoFechaN, Data_utilities.UcampoContra, Data_utilities.UcampoSaldo};

        if(!nombre.isEmpty()){
            try{
                Cursor fila = db.query(Data_utilities.tablaUsuarios, campos, Data_utilities.UcampoNombre + "=?", parametro, null, null, null);
                fila.moveToFirst();
                et_correo.setText(fila.getString(0));
                et_fechaN.setText(fila.getString(1));
                et_contra.setText(fila.getString(2));
                et_saldo.setText(fila.getString(3));
                fila.close();
            }catch (Exception e){
                Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();

                et_nombre.setText("");
                et_fechaN.setText("");
                et_correo.setText("");
                et_contra.setText("");
                et_saldo.setText("");
            }
        }
    }

    public void Limpia(View view){
        et_nombre.setText("");
        et_fechaN.setText("");
        et_correo.setText("");
        et_contra.setText("");
        et_saldo.setText("");
    }

    public void Actualiza(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String nombre = et_nombre.getText().toString();
        String fechaN = et_fechaN.getText().toString();
        String correo = et_correo.getText().toString();
        String contra = et_contra.getText().toString();
        String saldo = et_saldo.getText().toString();
        String[] parametro = {nombre};

        ContentValues actualiza = new ContentValues();
        actualiza.put(Data_utilities.UcampoNombre, nombre);
        actualiza.put(Data_utilities.UcampoFechaN, fechaN);
        actualiza.put(Data_utilities.UcampoCorreo, correo);
        actualiza.put(Data_utilities.UcampoContra, contra);
        actualiza.put(Data_utilities.UcampoSaldo, saldo);

        db.update(Data_utilities.tablaUsuarios, actualiza, Data_utilities.UcampoNombre + "=?",parametro);
        Toast.makeText(this, "Actualizacion exitosa", Toast.LENGTH_SHORT).show();
        db.close();

        et_nombre.setText("");
        et_fechaN.setText("");
        et_correo.setText("");
        et_contra.setText("");
        et_saldo.setText("");
    }

    private boolean validarEmail(String email) {
        String patron = "^[^\\_](\\w)+([\\w\\.\\-])*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,5})+";
        Pattern pattern = Pattern.compile(patron);
        Matcher match = pattern.matcher(email);
        return match.matches();
    }

    private boolean validarContra(String contra) {
        String patron = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d$@$!%*?&]{6,15}";
        Pattern pattern = Pattern.compile(patron);
        Matcher match = pattern.matcher(contra);
        return match.matches();
    }

    private boolean validarFecha(String fecha) {
        String patron = "^(19[0-9][0-9]|20[0-2][0-9])-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[01])";
        Pattern pattern = Pattern.compile(patron);
        Matcher match = pattern.matcher(fecha);
        return match.matches();
    }
}
