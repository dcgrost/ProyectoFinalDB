package com.example.alam.proyectofinaldb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogIn extends AppCompatActivity {

    AutoCompleteTextView et_correo;
    EditText et_contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        et_correo = (AutoCompleteTextView)findViewById(R.id.email);
        et_contra = (EditText) findViewById(R.id.password);
    }

    public void Iniciar (View view){
        String correo = et_correo.getText().toString();
        String contra = et_contra.getText().toString();

        if (correo.length() != 0 && contra.length() !=0 && validarContra(contra) && validarEmail(correo)){
            if (correo.contentEquals("ldp@admin.com") && contra.contentEquals("Admin123")){
                Intent myIntent = new Intent(view.getContext(), Administrador.class);
                startActivity(myIntent);
            }/*else{
                Intent myIntent = new Intent(view.getContext(), MainMenu.class);
                startActivity(myIntent);
            }*/
        }else{
            if (correo.length() == 0 && contra.length() == 0){
                Toast.makeText(this, "Ingresa datos", Toast.LENGTH_SHORT).show();
            }
            if (correo.length() == 0 && contra.length() != 0){
                Toast.makeText(this, "Ingresa un correo electrónico", Toast.LENGTH_SHORT).show();
            }
            if (contra.length() == 0 && correo.length() != 0){
                Toast.makeText(this, "Ingresa una contraseña", Toast.LENGTH_SHORT).show();
            }
            if (correo.length() != 0 && contra.length() !=0 && !validarEmail(correo)){
                Toast.makeText(this, "Ingresa un correo electrónico válido", Toast.LENGTH_SHORT).show();
            }
            if (validarEmail(correo) && correo.length() != 0 && contra.length() !=0 && !validarContra(contra)){
                Toast.makeText(this, "La contraseña debe contar con al menos 1\n" +
                        "número, una letra mayúscula y mínimo 6 caracteres", Toast.LENGTH_LONG).show();
            }
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

    public void Registrar (View view){
        Intent myIntent = new Intent(view.getContext(), Registro.class);
        startActivity(myIntent);
    }

}
