package com.example.alam.proyectofinaldb.Entidades;

public class Entidades_subtitulos {

    private int subtitulos_id;
    private String subtitulos_idioma;
    private String subtitulos_autor;
    private float subtitulos_precio;
    private int subtitulos_peliculas_id;
    private int subtitulos_capitulos_id;

    public Entidades_subtitulos(int subtitulos_id, String subtitulos_idioma, String subtitulos_autor, float subtitulos_precio, int subtitulos_peliculas_id, int subtitulos_capitulos_id) {
        this.subtitulos_id = subtitulos_id;
        this.subtitulos_idioma = subtitulos_idioma;
        this.subtitulos_autor = subtitulos_autor;
        this.subtitulos_precio = subtitulos_precio;
        this.subtitulos_peliculas_id = subtitulos_peliculas_id;
        this.subtitulos_capitulos_id = subtitulos_capitulos_id;
    }

    public Entidades_subtitulos() {
    }

    public int getSubtitulos_id() {
        return subtitulos_id;
    }

    public void setSubtitulos_id(int subtitulos_id) {
        this.subtitulos_id = subtitulos_id;
    }

    public String getSubtitulos_idioma() {
        return subtitulos_idioma;
    }

    public void setSubtitulos_idioma(String subtitulos_idioma) {
        this.subtitulos_idioma = subtitulos_idioma;
    }

    public String getSubtitulos_autor() {
        return subtitulos_autor;
    }

    public void setSubtitulos_autor(String subtitulos_autor) {
        this.subtitulos_autor = subtitulos_autor;
    }

    public float getSubtitulos_precio() {
        return subtitulos_precio;
    }

    public void setSubtitulos_precio(float subtitulos_precio) {
        this.subtitulos_precio = subtitulos_precio;
    }

    public int getSubtitulos_peliculas_id() {
        return subtitulos_peliculas_id;
    }

    public void setSubtitulos_peliculas_id(int subtitulos_peliculas_id) {
        this.subtitulos_peliculas_id = subtitulos_peliculas_id;
    }

    public int getSubtitulos_capitulos_id() {
        return subtitulos_capitulos_id;
    }

    public void setSubtitulos_capitulos_id(int subtitulos_capitulos_id) {
        this.subtitulos_capitulos_id = subtitulos_capitulos_id;
    }
}
