package com.example.alam.proyectofinaldb.Entidades;

import java.util.Date;

public class Entidades_usuarios {

    private int usuarios_id;
    private String usuarios_nombre;
    private String usuarios_correo;
    private Date usuarios_fechaNacimiento;
    private String usuarios_contraseña;
    private float usuarios_saldo;

    public Entidades_usuarios(int usuarios_id, String usuarios_nombre, String usuarios_correo, Date usuarios_fechaNacimiento, String usuarios_contraseña, float usuarios_saldo) {
        this.usuarios_id = usuarios_id;
        this.usuarios_nombre = usuarios_nombre;
        this.usuarios_correo = usuarios_correo;
        this.usuarios_fechaNacimiento = usuarios_fechaNacimiento;
        this.usuarios_contraseña = usuarios_contraseña;
        this.usuarios_saldo = usuarios_saldo;
    }

    public Entidades_usuarios() {
    }

    public int getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(int usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    public String getUsuarios_nombre() {
        return usuarios_nombre;
    }

    public void setUsuarios_nombre(String usuarios_nombre) {
        this.usuarios_nombre = usuarios_nombre;
    }

    public String getUsuarios_correo() {
        return usuarios_correo;
    }

    public void setUsuarios_correo(String usuarios_correo) {
        this.usuarios_correo = usuarios_correo;
    }

    public Date getUsuarios_fechaNacimiento() {
        return usuarios_fechaNacimiento;
    }

    public void setUsuarios_fechaNacimiento(Date usuarios_fechaNacimiento) {
        this.usuarios_fechaNacimiento = usuarios_fechaNacimiento;
    }

    public String getUsuarios_contraseña() {
        return usuarios_contraseña;
    }

    public void setUsuarios_contraseña(String usuarios_contraseña) {
        this.usuarios_contraseña = usuarios_contraseña;
    }

    public float getUsuarios_saldo() {
        return usuarios_saldo;
    }

    public void setUsuarios_saldo(int usuarios_saldo) {
        this.usuarios_saldo = usuarios_saldo;
    }
}