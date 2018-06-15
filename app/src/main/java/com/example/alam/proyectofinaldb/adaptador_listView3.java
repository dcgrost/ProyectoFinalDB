package com.example.alam.proyectofinaldb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adaptador_listView3 extends BaseAdapter{

    Context contexto;
    List<datos_listView3> listaObjetos;

    public adaptador_listView3(Context contexto, List<datos_listView3> listaObjetos) {
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
        view = inflate.inflate(R.layout.item_listview3, null);

        TextView usuario = (TextView)view.findViewById(R.id.usuario);
        TextView fecha = (TextView)view.findViewById(R.id.fecha);
        TextView contenido = (TextView)view.findViewById(R.id.contenido);

        usuario.setText(listaObjetos.get(position).getUsuario().toString());
        fecha.setText(listaObjetos.get(position).getFecha().toString());
        contenido.setText(listaObjetos.get(position).getContenido().toString());

        return  view;
    }
}
