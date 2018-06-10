package com.example.alam.proyectofinaldb;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {

    AutoCompleteTextView et_correo;
    EditText et_contra, et_nombre, et_fechaN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et_correo = (AutoCompleteTextView)findViewById(R.id.email);
        et_contra = (EditText) findViewById(R.id.password);
        et_nombre = (EditText) findViewById(R.id.nombre);
        et_fechaN = (EditText) findViewById(R.id.fechaN);

    }

    public void Alta(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String nombre = et_nombre.getText().toString();
        String fechaN = et_fechaN.getText().toString();
        String correo = et_correo.getText().toString();
        String contra = et_contra.getText().toString();

        float saldo = 100.00f;

        if (nombre.length() == 0 && fechaN.length() == 0 && correo.length() == 0 && contra.length() == 0){
            Toast.makeText(this, "Ingresa datos", Toast.LENGTH_SHORT).show();
        }
        if (nombre.length() != 0 && fechaN.length() != 0 && correo.length() == 0 && contra.length() != 0){
            Toast.makeText(this, "Ingresa una correo electrónico", Toast.LENGTH_SHORT).show();
        }
        if (nombre.length() != 0 && fechaN.length() != 0 && correo.length() != 0 && contra.length() == 0){
            Toast.makeText(this, "Ingresa una contraseña", Toast.LENGTH_SHORT).show();
        }
        if (nombre.length() == 0 && fechaN.length() != 0 && correo.length() != 0 && contra.length() != 0){
            Toast.makeText(this, "Ingresa un nombre", Toast.LENGTH_SHORT).show();
        }
        if (nombre.length() != 0 && fechaN.length() == 0 && correo.length() != 0 && contra.length() != 0){
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

            long idResultante = db.insert(Data_utilities.tablaUsuarios, Data_utilities.UcampoId, alta);
            Toast.makeText(this, "Id registro: "+ idResultante, Toast.LENGTH_SHORT).show();
            db.close();

            et_nombre.setText("");
            et_fechaN.setText("");
            et_correo.setText("");
            et_contra.setText("");

            Intent myIntent = new Intent(view.getContext(), LogIn.class);
            startActivity(myIntent);
        }
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
