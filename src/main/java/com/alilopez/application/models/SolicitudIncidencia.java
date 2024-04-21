package com.alilopez.application.models;

public class SolicitudIncidencia extends Incidencia {
    private String nombre;
    private String ud;

    public SolicitudIncidencia(String tipo, String color, String descripcion, String fecha, String aula, String nombre, String ud) {
        super(tipo, color, descripcion, fecha, aula);
        this.nombre = nombre;
        this.ud = ud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUd() {
        return ud;
    }

    public void setUd(String ud) {
        this.ud = ud;
    }
}