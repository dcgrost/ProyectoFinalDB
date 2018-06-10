package com.example.alam.proyectofinaldb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adaptador_listView extends BaseAdapter{

    Context contexto;
    List<datos_listView> listaObjetos;

    public adaptador_listView(Context contexto, List<datos_listView> listaObjetos) {
        this.contexto = contexto;
        this.listaObjetos = listaObjetos;
    }

    @Override
    public int getCount() {
        return listaObjetos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaObjetos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaObjetos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflate = LayoutInflater.from(contexto);
        vista = inflate.inflate(R.layout.item_listview, null);

        ImageView imagen = (ImageView) vista.findViewById(R.id.imageView);
        TextView titulo = (TextView) vista.findViewById(R.id.titulo);
        TextView sinopsis = (TextView) vista.findViewById(R.id.sinopsis);

        titulo.setText(listaObjetos.get(position).getTitulo().toString());
        sinopsis.setText(listaObjetos.get(position).getSinopsis().toString());
        imagen.setImageResource(listaObjetos.get(position).getImagen());

        return vista;
    }
}
