package com.example.alam.proyectofinaldb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adaptador_listView2 extends BaseAdapter{

    Context contexto;
    List<datos_listView2> listaObjetos;

    public adaptador_listView2(Context contexto, List<datos_listView2> listaObjetos) {
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
        View view = convertView;

        LayoutInflater inflate = LayoutInflater.from(contexto);
        view = inflate.inflate(R.layout.item_listview2,null);

        ImageView imagen  = (ImageView)view.findViewById(R.id.imageView);
        TextView titulo = (TextView)view.findViewById(R.id.titulo);

        titulo.setText(listaObjetos.get(position).getTitulo().toString());
        imagen.setImageResource(listaObjetos.get(position).getImagen());

        return view;
    }
}
