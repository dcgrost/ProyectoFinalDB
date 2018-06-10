package com.example.alam.proyectofinal.Entidades;

public class Entidades_peliculasUsuarios {

    private int peliculasUsuarios_id;
    private int peliculasUsuarios_usuarios_id;
    private int peliculasUsuarios_peliculas_id;

    public Entidades_peliculasUsuarios(int peliculasUsuarios_id, int peliculasUsuarios_usuarios_id, int peliculasUsuarios_peliculas_id) {
        this.peliculasUsuarios_id = peliculasUsuarios_id;
        this.peliculasUsuarios_usuarios_id = peliculasUsuarios_usuarios_id;
        this.peliculasUsuarios_peliculas_id = peliculasUsuarios_peliculas_id;
    }

    public int getPeliculasUsuarios_id() {
        return peliculasUsuarios_id;
    }

    public void setPeliculasUsuarios_id(int peliculasUsuarios_id) {
        this.peliculasUsuarios_id = peliculasUsuarios_id;
    }

    public int getPeliculasUsuarios_usuarios_id() {
        return peliculasUsuarios_usuarios_id;
    }

    public void setPeliculasUsuarios_usuarios_id(int peliculasUsuarios_usuarios_id) {
        this.peliculasUsuarios_usuarios_id = peliculasUsuarios_usuarios_id;
    }

    public int getPeliculasUsuarios_peliculas_id() {
        return peliculasUsuarios_peliculas_id;
    }

    public void setPeliculasUsuarios_peliculas_id(int peliculasUsuarios_peliculas_id) {
        this.peliculasUsuarios_peliculas_id = peliculasUsuarios_peliculas_id;
    }
}
