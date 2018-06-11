package com.example.alam.proyectofinaldb;

import com.example.alam.proyectofinaldb.Entidades.Entidades_peliculas;

public class datos_listView {
    private int id;
    private String titulo;
    private String sinopsis;
    private int imagen;

    public datos_listView(int id, String titulo, String sinopsis, int imagen) {
        this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
