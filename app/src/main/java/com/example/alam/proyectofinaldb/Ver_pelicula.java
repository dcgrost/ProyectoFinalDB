package com.example.alam.proyectofinaldb;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alam.proyectofinaldb.Entidades.Entidades_criticas;
import com.example.alam.proyectofinaldb.Entidades.Entidades_peliculas;
import com.example.alam.proyectofinaldb.Entidades.Entidades_temporadas;
import com.example.alam.proyectofinaldb.Entidades.Entidades_usuarios;
import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Ver_pelicula extends AppCompatActivity {

    TextView tv_titulo, tv_sinopsis, tv_genero, tv_idiomaO, tv_fechaE, tv_precio, tv_saldo;
    ImageView img;

    ListView listaDatos;
    ArrayList<datos_listView3> lista;
    ArrayList<Entidades_criticas> listaCriticas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pelicula);
        String userId = getIntent().getStringExtra("userId");
        String peliculaId = getIntent().getStringExtra("peliculaId");

        tv_titulo = (TextView)findViewById(R.id.titulo);
        tv_sinopsis = (TextView)findViewById(R.id.sinopsis);
        tv_genero = (TextView)findViewById(R.id.genero);
        tv_idiomaO = (TextView)findViewById(R.id.idiomaO);
        tv_fechaE = (TextView)findViewById(R.id.fechaE);
        tv_precio = (TextView)findViewById(R.id.precio);
        img = (ImageView)findViewById(R.id.imageView);
        tv_saldo = (TextView)findViewById(R.id.saldo);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String id = peliculaId;
        String[] parametro = {id};
        String[] campos = {Data_utilities.PcampoTitulo, Data_utilities.PcampoSinopsis, Data_utilities.PcampoGenero, Data_utilities.PcampoIdiomaOriginal, Data_utilities.PcampoFechaEstreno, Data_utilities.PcampoPrecio, Data_utilities.PcampoImg};

        Cursor fila2 = db.query(Data_utilities.tablaPeliculas, campos, Data_utilities.PcampoId+ "=?", parametro, null, null, null);
        fila2.moveToFirst();
        tv_titulo.setText(fila2.getString(0));
        tv_sinopsis.setText(fila2.getString(1));
        tv_genero.setText(fila2.getString(2));
        tv_idiomaO.setText(fila2.getString(3));
        tv_fechaE.setText(fila2.getString(4));
        tv_precio.setText(fila2.getString(5));
        img.setImageResource(fila2.getInt(6));
        fila2.close();

        //Saldo del usuario

        String nombre = userId;
        String[] idusuario = {nombre};
        String[] saldo = {Data_utilities.UcampoSaldo};

        Cursor cursor = db.query(Data_utilities.tablaUsuarios,saldo, Data_utilities.UcampoId+"=?",idusuario,null, null,null);
        cursor.moveToFirst();
        tv_saldo.setText(cursor.getString(0));
        cursor.close();

        //Llenado de list view criticas

        listaDatos = (ListView)findViewById(R.id.listView);

        Entidades_criticas critica = null;

        listaCriticas= new ArrayList<Entidades_criticas>();
        String query = "select " +Data_utilities.CRcampoId+", "+Data_utilities.UcampoNombre+", "+Data_utilities.CRcampoFecha+", "+ Data_utilities.CRcampoComentario+" from "+Data_utilities.tablaCriticas
                +" inner join " +Data_utilities.tablaUsuarios+ " on "+Data_utilities.UcampoId+" = "+Data_utilities.CRcampoUsuariosID
                +" inner join " +Data_utilities.tablaPeliculas+ " on "+Data_utilities.PcampoId+" = "+Data_utilities.CRcampoPeliculasID+" where " +Data_utilities.PcampoId+ " = '" +peliculaId+"'";

        Cursor fila = db.rawQuery(query,null);

        while(fila.moveToNext()){
            critica = new Entidades_criticas();
            critica.setCriticas_id(fila.getInt(0));
            critica.setCriticas_usuario_id(fila.getString(1));
            critica.setCriticas_fecha(fila.getString(2));
            critica.setCriticas_comentario(fila.getString(3));

            listaCriticas.add(critica);
        }

        lista = new ArrayList<datos_listView3>();

        for (int i=0;i<listaCriticas.size();i++){
            lista.add(new datos_listView3(listaCriticas.get(i).getCriticas_id(),listaCriticas.get(i).getCriticas_usuario(),listaCriticas.get(i).getCriticas_fecha(),listaCriticas.get(i).getCriticas_comentario()));
        }

        adaptador_listView3 miadaptador = new adaptador_listView3(getApplicationContext(), lista);
        listaDatos.setAdapter(miadaptador);
    }

    public void Comprar(View view){
        String userId = getIntent().getStringExtra("userId");
        String peliculaId = getIntent().getStringExtra("peliculaId");

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String query = "select "+ Data_utilities.PUcampoId+", "+Data_utilities.PUcampoUsuariosID+", "+Data_utilities.PUcampoPeliculasID+" from "+Data_utilities.tablaPeliculasUsuarios
                +" where "+Data_utilities.PUcampoUsuariosID+" = '"+userId+"' and "+Data_utilities.PUcampoPeliculasID+" = '"+peliculaId+"'";

        Cursor fila = db.rawQuery(query,null);

        try{
            fila.moveToFirst();
            int id = fila.getInt(0);
            int usuarioId = fila.getInt(1);
            int peliId = fila.getInt(2);
            fila.close();

            String x = String.valueOf(usuarioId);
            String y = String.valueOf(peliId);

            if (userId.contentEquals(x) && peliculaId.contentEquals(y)){
                Toast.makeText(this,"Película ya comprada",Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            String precio = tv_precio.getText().toString();
            String saldo = tv_saldo.getText().toString();

            int saldo_actual = Integer.parseInt(saldo) - Integer.parseInt(precio);
            String saldoString = String.valueOf(saldo_actual);

            String[] parametro = {userId};

            ContentValues actualiza = new ContentValues();
            actualiza.put(Data_utilities.UcampoSaldo, saldoString);

            db.update(Data_utilities.tablaUsuarios, actualiza, Data_utilities.UcampoId+ "=?",parametro);

            tv_saldo.setText(saldoString);

            ContentValues alta = new ContentValues();
            alta.put(Data_utilities.PUcampoUsuariosID, userId);
            alta.put(Data_utilities.PUcampoPeliculasID, peliculaId);

            db.insert(Data_utilities.tablaPeliculasUsuarios,Data_utilities.PUcampoId,alta);
            Toast.makeText(this, "Compra realizada", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }


    public void Criticar(View view){
        String userId = getIntent().getStringExtra("userId");
        String peliculaId = getIntent().getStringExtra("peliculaId");
        String genero = getIntent().getStringExtra("genero");
        String tipo = getIntent().getStringExtra("tipo");
        String nomPeli = getIntent().getStringExtra("nomPeli");
        Intent myIntent = new Intent(view.getContext(), Critica_pelicula.class);
        myIntent.putExtra("peliculaId", peliculaId);
        myIntent.putExtra("genero", genero);
        myIntent.putExtra("userId", userId);
        myIntent.putExtra("tipo", tipo);
        startActivity(myIntent);
    }
    public void Perfilpp (View view){
        Intent myIntent = new Intent(view.getContext(), Perfil.class);
        String userId = getIntent().getStringExtra("userId");
        myIntent.putExtra("userId", userId);
        startActivity(myIntent);
    }
    public void RegresaPeliculas(View view){
        String userId = getIntent().getStringExtra("userId");
        String genero = getIntent().getStringExtra("genero");
        String tipo = getIntent().getStringExtra("tipo");
        Intent myIntent = new Intent(view.getContext(), Peliculas.class);
        myIntent.putExtra("genero", genero);
        myIntent.putExtra("userId", userId);
        myIntent.putExtra("tipo", tipo);
        startActivity(myIntent);
    }
    public void misPeliculasp(View view){
        String userId = getIntent().getStringExtra("userId");
        String genero = getIntent().getStringExtra("genero");
        String tipo = getIntent().getStringExtra("tipo");
        Intent myIntent = new Intent(view.getContext(), Mis_peliculas.class);
        myIntent.putExtra("genero", genero);
        myIntent.putExtra("userId", userId);
        myIntent.putExtra("tipo", tipo);
        startActivity(myIntent);
    }
}
