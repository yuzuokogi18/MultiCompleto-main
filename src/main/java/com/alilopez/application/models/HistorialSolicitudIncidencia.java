package com.alilopez.application.models;

import java.util.ArrayList;

public class HistorialSolicitudIncidencia extends SolicitudIncidencia {
    private ArrayList<Incidencia> incidencias;

    public HistorialSolicitudIncidencia(ArrayList<Incidencia> incidencias, String tipo, String color, String descripción, String fecha, String aula, String ud) {
        super(tipo, color, descripción, fecha, aula, null, ud);
        this.incidencias = incidencias;
    }

    public void addIncidencia(Incidencia incidencia) {
        incidencias.add(incidencia);
    }

    public void deleteIncidencia(int id) {
        incidencias.removeIf(incidencia -> incidencia.getId() == id);
    }

    public ArrayList<Incidencia> getIncidencias() {
        return incidencias;
    }
}