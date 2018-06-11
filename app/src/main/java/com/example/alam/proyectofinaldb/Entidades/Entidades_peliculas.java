package com.example.alam.proyectofinaldb.Entidades;

import java.util.Date;

public class Entidades_peliculas {

    private int peliculas_id;
    private String peliculas_titulo;
    private String peliculas_genero;
    private String peliculas_sinopsis;
    private String peliculas_idiomaOriginal;
    private Date peliculas_fechaEstreno;
    private float peliculas_precio;
    private int peliculas_imagen;

    public Entidades_peliculas(int peliculas_id, String peliculas_titulo, String peliculas_genero, String peliculas_sinopsis, String peliculas_idiomaOriginal, Date peliculas_fechaEstreno, float peliculas_precio, int peliculas_imagen) {
        this.peliculas_id = peliculas_id;
        this.peliculas_titulo = peliculas_titulo;
        this.peliculas_genero = peliculas_genero;
        this.peliculas_sinopsis = peliculas_sinopsis;
        this.peliculas_idiomaOriginal = peliculas_idiomaOriginal;
        this.peliculas_fechaEstreno = peliculas_fechaEstreno;
        this.peliculas_precio = peliculas_precio;
        this.peliculas_imagen = peliculas_imagen;
    }

    public Entidades_peliculas() {
    }

    public int getPeliculas_id() {
        return peliculas_id;
    }

    public void setPeliculas_id(int peliculas_id) {
        this.peliculas_id = peliculas_id;
    }

    public String getPeliculas_titulo() {
        return peliculas_titulo;
    }

    public void setPeliculas_titulo(String peliculas_titulo) {
        this.peliculas_titulo = peliculas_titulo;
    }

    public String getPeliculas_genero() {
        return peliculas_genero;
    }

    public void setPeliculas_genero(String peliculas_genero) {
        this.peliculas_genero = peliculas_genero;
    }

    public String getPeliculas_sinopsis() {
        return peliculas_sinopsis;
    }

    public void setPeliculas_sinopsis(String peliculas_sinopsis) {
        this.peliculas_sinopsis = peliculas_sinopsis;
    }

    public String getPeliculas_idiomaOriginal() {
        return peliculas_idiomaOriginal;
    }

    public void setPeliculas_idiomaOriginal(String peliculas_idiomaOriginal) {
        this.peliculas_idiomaOriginal = peliculas_idiomaOriginal;
    }

    public Date getPeliculas_fechaEstreno() {
        return peliculas_fechaEstreno;
    }

    public void setPeliculas_fechaEstreno(Date peliculas_fechaEstreno) {
        this.peliculas_fechaEstreno = peliculas_fechaEstreno;
    }

    public float getPeliculas_precio() {
        return peliculas_precio;
    }

    public void setPeliculas_Imagen(float peliculas_precio) {
        this.peliculas_precio = peliculas_precio;
    }

    public int getPeliculas_imagen() {
        return peliculas_imagen;
    }

    public void setPeliculas_imagen(int imagen) {
        this.peliculas_imagen = imagen;
    }
}
