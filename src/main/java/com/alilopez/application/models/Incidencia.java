package com.alilopez.application.models;

import java.util.ArrayList;

public class Incidencia {
    private int id;
    private String tipo;
    private String color;
    private String descripcion;
    private String fecha;
    private String nombredelobjeto;
    private String aula;

    public Incidencia(int id, String tipo, String color, String descripcion, String fecha, String aula) {
        this.id = id;
        this.tipo = tipo;
        this.color = color;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.aula = aula;
    }

    public Incidencia(String descripcion, String nombreObjeto, String tipo, String aula, String ud, String color, String fecha) {


    }

    public Incidencia(String tipo, String color, String descripcion, String fecha, String aula) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombredelobjeto() {
        return nombredelobjeto;
    }

    public void setNombredelobjeto(String nombredelobjeto) {
        this.nombredelobjeto = nombredelobjeto;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
}