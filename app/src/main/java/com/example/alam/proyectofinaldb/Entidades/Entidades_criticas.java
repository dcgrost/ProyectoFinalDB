package com.example.alam.proyectofinaldb.Entidades;

import java.util.Date;

public class Entidades_criticas {

    private int criticas_id;
    private String criticas_comentario;
    private String criticas_fecha;
    private String criticas_usuario;
    private int criticas_peliculas_id;
    private int criticas_capitulos_id;

    public Entidades_criticas(int criticas_id, String criticas_comentario, String criticas_fecha, String criticas_usuario_id, int criticas_peliculas_id, int criticas_capitulos_id) {
        this.criticas_id = criticas_id;
        this.criticas_comentario = criticas_comentario;
        this.criticas_fecha = criticas_fecha;
        this.criticas_usuario = criticas_usuario_id;
        this.criticas_peliculas_id = criticas_peliculas_id;
        this.criticas_capitulos_id = criticas_capitulos_id;
    }

    public Entidades_criticas() {
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

    public String getCriticas_fecha() {
        return criticas_fecha;
    }

    public void setCriticas_fecha(String criticas_fecha) {
        this.criticas_fecha = criticas_fecha;
    }

    public String getCriticas_usuario() {
        return criticas_usuario;
    }

    public void setCriticas_usuario_id(String criticas_usuario_id) {
        this.criticas_usuario = criticas_usuario_id;
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
