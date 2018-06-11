package com.example.alam.proyectofinaldb.Entidades;

public class Entidades_seriesUsuarios {

    private int seriesUsuarios_id;
    private int seriesUsuarios_usuarios_id;
    private int seriesUsuarios_series_id;

    public Entidades_seriesUsuarios(int seriesUsuarios_id, int seriesUsuarios_usuarios_id, int seriesUsuarios_series_id) {
        this.seriesUsuarios_id = seriesUsuarios_id;
        this.seriesUsuarios_usuarios_id = seriesUsuarios_usuarios_id;
        this.seriesUsuarios_series_id = seriesUsuarios_series_id;
    }

    public Entidades_seriesUsuarios() {
    }

    public int getSeriesUsuarios_id() {
        return seriesUsuarios_id;
    }

    public void setSeriesUsuarios_id(int seriesUsuarios_id) {
        this.seriesUsuarios_id = seriesUsuarios_id;
    }

    public int getSeriesUsuarios_usuarios_id() {
        return seriesUsuarios_usuarios_id;
    }

    public void setSeriesUsuarios_usuarios_id(int seriesUsuarios_usuarios_id) {
        this.seriesUsuarios_usuarios_id = seriesUsuarios_usuarios_id;
    }

    public int getSeriesUsuarios_series_id() {
        return seriesUsuarios_series_id;
    }

    public void setSeriesUsuarios_series_id(int seriesUsuarios_series_id) {
        this.seriesUsuarios_series_id = seriesUsuarios_series_id;
    }
}
