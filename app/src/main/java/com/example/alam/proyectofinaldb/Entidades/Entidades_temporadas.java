package com.example.alam.proyectofinaldb.Entidades;

import java.util.Date;

public class Entidades_temporadas {

    private int temporadas_id;
    private String temporadas_titulo;
    private String temporadas_fechaEstreno;
    private String temporadas_fechaProduccion;
    private String temporadas_img;
    private int temporadas_imagen;
    private int temporadas_series_id;

    public Entidades_temporadas(int temporadas_id, String temporadas_titulo, String temporadas_fechaEstreno, String temporadas_fechaProduccion, String temporadas_img, int temporadas_imagen, int temporadas_series_id) {
        this.temporadas_id = temporadas_id;
        this.temporadas_titulo = temporadas_titulo;
        this.temporadas_fechaEstreno = temporadas_fechaEstreno;
        this.temporadas_fechaProduccion = temporadas_fechaProduccion;
        this.temporadas_img = temporadas_img;
        this.temporadas_imagen = temporadas_imagen;
        this.temporadas_series_id = temporadas_series_id;
    }

    public Entidades_temporadas() {
    }

    public int getTemporadas_id() {
        return temporadas_id;
    }

    public void setTemporadas_id(int temporadas_id) {
        this.temporadas_id = temporadas_id;
    }

    public String getTemporadas_titulo() {
        return temporadas_titulo;
    }

    public void setTemporadas_titulo(String temporadas_titulo) {
        this.temporadas_titulo = temporadas_titulo;
    }

    public String getTemporadas_fechaEstreno() {
        return temporadas_fechaEstreno;
    }

    public void setTemporadas_fechaEstreno(String temporadas_fechaEstreno) {
        this.temporadas_fechaEstreno = temporadas_fechaEstreno;
    }

    public String getTemporadas_fechaProduccion() {
        return temporadas_fechaProduccion;
    }

    public void setTemporadas_fechaProduccion(String temporadas_fechaProduccion) {
        this.temporadas_fechaProduccion = temporadas_fechaProduccion;
    }

    public String getTemporadas_img() {
        return temporadas_img;
    }

    public void setTemporadas_img(String temporadas_img) {
        this.temporadas_img = temporadas_img;
    }

    public int getTemporadas_imagen() {
        return temporadas_imagen;
    }

    public void setTemporadas_imagen(int temporadas_imagen) {
        this.temporadas_imagen = temporadas_imagen;
    }

    public int getTemporadas_series_id() {
        return temporadas_series_id;
    }

    public void setTemporadas_series_id(int temporadas_series_id) {
        this.temporadas_series_id = temporadas_series_id;
    }
}
