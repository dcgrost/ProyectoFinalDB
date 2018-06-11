package com.example.alam.proyectofinaldb.Entidades;

public class Entidades_capitulos {

    private int capitulos_id;
    private String capitulos_titulo;
    private String capitulos_duracion;
    private float capitulos_precio;
    private String capitulos_sinopsis;
    private int capitulos_imagen;
    private int capitulos_temporadas_id;

    public Entidades_capitulos(int capitulos_id, String capitulos_titulo, String capitulos_duracion, float capitulos_precio, String capitulos_sinopsis, int capitulos_imagen, int capitulos_temporadas_id) {
        this.capitulos_id = capitulos_id;
        this.capitulos_titulo = capitulos_titulo;
        this.capitulos_duracion = capitulos_duracion;
        this.capitulos_precio = capitulos_precio;
        this.capitulos_sinopsis = capitulos_sinopsis;
        this.capitulos_imagen = capitulos_imagen;
        this.capitulos_temporadas_id = capitulos_temporadas_id;
    }

    public Entidades_capitulos() {
    }

    public int getCapitulos_id() {
        return capitulos_id;
    }

    public void setCapitulos_id(int capitulos_id) {
        this.capitulos_id = capitulos_id;
    }

    public String getCapitulos_titulo() {
        return capitulos_titulo;
    }

    public void setCapitulos_titulo(String capitulos_titulo) {
        this.capitulos_titulo = capitulos_titulo;
    }

    public String getCapitulos_duracion() {
        return capitulos_duracion;
    }

    public void setCapitulos_duracion(String capitulos_duracion) {
        this.capitulos_duracion = capitulos_duracion;
    }

    public float getCapitulos_precio() {
        return capitulos_precio;
    }

    public void setCapitulos_precio(float capitulos_precio) {
        this.capitulos_precio = capitulos_precio;
    }

    public String getCapitulos_sinopsis() {
        return capitulos_sinopsis;
    }

    public void setCapitulos_sinopsis(String capitulos_sinopsis) {
        this.capitulos_sinopsis = capitulos_sinopsis;
    }

    public int getCapitulos_imagen() {
        return capitulos_imagen;
    }

    public void setCapitulos_imagen(int capitulos_imagen) {
        this.capitulos_imagen = capitulos_imagen;
    }

    public int getCapitulos_temporadas_id() {
        return capitulos_temporadas_id;
    }

    public void setCapitulos_temporadas_id(int capitulos_temporadas_id) {
        this.capitulos_temporadas_id = capitulos_temporadas_id;
    }
}
