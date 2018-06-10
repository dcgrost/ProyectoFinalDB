package com.example.alam.proyectofinaldb.Entidades;

import java.util.Date;

public class Entidades_criticas {

    private int criticas_id;
    private String criticas_comentario;
    private Date criticas_fecha;
    private int criticas_usuario_id;
    private int criticas_peliculas_id;
    private int criticas_capitulos_id;

    public Entidades_criticas(int criticas_id, String criticas_comentario, Date criticas_fecha, int criticas_usuario_id, int criticas_peliculas_id, int criticas_capitulos_id) {
        this.criticas_id = criticas_id;
        this.criticas_comentario = criticas_comentario;
        this.criticas_fecha = criticas_fecha;
        this.criticas_usuario_id = criticas_usuario_id;
        this.criticas_peliculas_id = criticas_peliculas_id;
        this.criticas_capitulos_id = criticas_capitulos_id;
    }

    public int getCriticas_id() {
        return criticas_id;
    }

    public void setCriticas_id(int criticas_id) {
        this.criticas_id = criticas_id;
    }

    public String getCriticas_comentario() {
        return criticas_comentario;
    }

    public void setCriticas_comentario(String criticas_comentario) {
        this.criticas_comentario = criticas_comentario;
    }

    public Date getCriticas_fecha() {
        return criticas_fecha;
    }

    public void setCriticas_fecha(Date criticas_fecha) {
        this.criticas_fecha = criticas_fecha;
    }

    public int getCriticas_usuario_id() {
        return criticas_usuario_id;
    }

    public void setCriticas_usuario_id(int criticas_usuario_id) {
        this.criticas_usuario_id = criticas_usuario_id;
    }

    public int getCriticas_peliculas_id() {
        return criticas_peliculas_id;
    }

    public void setCriticas_peliculas_id(int criticas_peliculas_id) {
        this.criticas_peliculas_id = criticas_peliculas_id;
    }

    public int getCriticas_capitulos_id() {
        return criticas_capitulos_id;
    }

    public void setCriticas_capitulos_id(int criticas_capitulos_id) {
        this.criticas_capitulos_id = criticas_capitulos_id;
    }
}
