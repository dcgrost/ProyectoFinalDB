package com.example.alam.proyectofinaldb.Entidades;

import android.provider.ContactsContract;

import java.util.Date;

public class Entidades_temporadas {

    private int temporadas_id;
    private String temporadas_titulo;
    private Date temporadas_fechaEstreno;
    private Date temporadas_fechaProduccion;
    private int temporadas_imagen;
    private int temporadas_series_id;

    public Entidades_temporadas(int temporadas_id, String temporadas_titulo, Date temporadas_fechaEstreno, Date temporadas_fechaProduccion, int temporadas_imagen, int temporadas_series_id) {
        this.temporadas_id = temporadas_id;
        this.temporadas_titulo = temporadas_titulo;
        this.temporadas_fechaEstreno = temporadas_fechaEstreno;
        this.temporadas_fechaProduccion = temporadas_fechaProduccion;
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

    public Date getTemporadas_fechaEstreno() {
        return temporadas_fechaEstreno;
    }

    public void setTemporadas_fechaEstreno(Date temporadas_fechaEstreno) {
        this.temporadas_fechaEstreno = temporadas_fechaEstreno;
    }

    public Date getTemporadas_fechaProduccion() {
        return temporadas_fechaProduccion;
    }

    public void setTemporadas_fechaProduccion(Date temporadas_fechaProduccion) {
        this.temporadas_fechaProduccion = temporadas_fechaProduccion;
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