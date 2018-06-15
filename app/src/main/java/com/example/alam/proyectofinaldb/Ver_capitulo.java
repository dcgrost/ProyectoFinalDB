package com.example.alam.proyectofinaldb;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alam.proyectofinaldb.Entidades.Entidades_capitulos;
import com.example.alam.proyectofinaldb.Entidades.Entidades_criticas;
import com.example.alam.proyectofinaldb.Entidades.Entidades_peliculas;
import com.example.alam.proyectofinaldb.Utilities.Data_utilities;

import java.util.ArrayList;

public class Ver_capitulo extends AppCompatActivity {

    TextView tv_titulo, tv_sinopsis, tv_genero, tv_fechaE, tv_precio, tv_serie, tv_temporada;
    ImageView img;

    ListView listaDatos;
    ArrayList<datos_listView3> lista;
    ArrayList<Entidades_criticas> listaCriticas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_capitulo);
        String userId = getIntent().getStringExtra("userId");

        String capitulo = getIntent().getStringExtra("capitulo");

        tv_titulo = (TextView)findViewById(R.id.titulo);
        tv_sinopsis = (TextView)findViewById(R.id.sinopsis);
        tv_genero = (TextView)findViewById(R.id.genero);
        tv_serie = (TextView)findViewById(R.id.serie);
        tv_temporada = (TextView)findViewById(R.id.temporada);
        tv_fechaE = (TextView)findViewById(R.id.fechaE);
        tv_precio = (TextView)findViewById(R.id.precio);
        img = (ImageView)findViewById(R.id.imageView);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Entidades_capitulos capituloM = null;

        String query2 = "select "+Data_utilities.CcampoTitulo+", "+Data_utilities.CcampoSinopsis+", "+Data_utilities.CcampoPrecio+", "+Data_utilities.CcampoImg+", "
                +Data_utilities.ScampoGenero+", "+Data_utilities.ScampoTitulo+", "+Data_utilities.TcampoTitulo+", "+Data_utilities.TcampoFechaEstreno+" from "+Data_utilities.tablaCapitulos+" inner join "
                +Data_utilities.tablaTempoaradas+" on "+Data_utilities.TcampoId+" = "+Data_utilities.CcampoTemporadasID+" inner join "
                +Data_utilities.tablaSeries+" on "+Data_utilities.ScampoId+" = "+Data_utilities.TcampoSeriesID+" where "+Data_utilities.CcampoId+" = '"+capitulo+"'";


        Cursor fila2 = db.rawQuery(query2,null);
        fila2.moveToFirst();

        tv_titulo.setText(fila2.getString(0));
        tv_sinopsis.setText(fila2.getString(1));
        tv_precio.setText(fila2.getString(2));
        img.setImageResource(fila2.getInt(3));
        tv_genero.setText(fila2.getString(4));
        tv_serie.setText(fila2.getString(5));
        tv_temporada.setText(fila2.getString(6));
        tv_fechaE.setText(fila2.getString(7));
        fila2.close();

        //Llenado de list view criticas

        listaDatos = (ListView)findViewById(R.id.listView);

        Entidades_criticas critica = null;

        listaCriticas= new ArrayList<Entidades_criticas>();
        String query = "select " +Data_utilities.CRcampoId+", "+Data_utilities.UcampoNombre+", "+Data_utilities.CRcampoFecha+", "+ Data_utilities.CRcampoComentario+" from "+Data_utilities.tablaCriticas
                +" inner join " +Data_utilities.tablaUsuarios+ " on "+Data_utilities.UcampoId+" = "+Data_utilities.CRcampoUsuariosID
                +" inner join " +Data_utilities.tablaCapitulos+ " on "+Data_utilities.CcampoId+" = "+Data_utilities.CRcampoCapitulosID+" where " +Data_utilities.CRcampoCapitulosID+ " = '" +capitulo+"'";

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
}
