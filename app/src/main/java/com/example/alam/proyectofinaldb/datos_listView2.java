package com.example.alam.proyectofinaldb;

public class datos_listView2 {
    private int id;
    private String titulo;
    private int imagen;

    public datos_listView2(int id, String titulo, int imagen) {
        this.id = id;
        this.titulo = titulo;
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

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
