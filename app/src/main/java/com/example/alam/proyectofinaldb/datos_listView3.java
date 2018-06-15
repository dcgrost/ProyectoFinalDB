package com.example.alam.proyectofinaldb;

public class datos_listView3 {
    private int id;
    private String usuario;
    private String fecha;
    private String contenido;

    public datos_listView3(int id, String usuario, String fecha, String contenido) {
        this.id = id;
        this.usuario = usuario;
        this.fecha = fecha;
        this.contenido = contenido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
