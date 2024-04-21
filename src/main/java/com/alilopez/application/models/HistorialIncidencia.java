package com.alilopez.application.models;

import java.util.ArrayList;

public class HistorialIncidencia {
    private ArrayList<Incidencia> listaIncidencias;

    public HistorialIncidencia() {
        listaIncidencias = new ArrayList<>();
    }

    public void agregarIncidencia(Incidencia incidencia) {
        listaIncidencias.add(incidencia);
    }

    public ArrayList<Incidencia> obtenerTodasLasIncidencias() {
        return listaIncidencias;
    }

    public ArrayList<Incidencia> obtenerIncidenciasPorTipo(String tipo) {
        ArrayList<Incidencia> incidenciasPorTipo = new ArrayList<>();
        for (Incidencia incidencia : listaIncidencias) {
            if (incidencia.getTipo().equals(tipo)) {
                incidenciasPorTipo.add(incidencia);
            }
        }
        return incidenciasPorTipo;
    }

    // Metodo para obtener las incidencias ocurridas en una fecha específica
    public ArrayList<Incidencia> obtenerIncidenciasPorFecha(String fecha) {
        ArrayList<Incidencia> incidenciasPorFecha = new ArrayList<>();
        for (Incidencia incidencia : listaIncidencias) {
            if (incidencia.getFecha().equals(fecha)) {
                incidenciasPorFecha.add(incidencia);
            }
        }
        return incidenciasPorFecha;
    }

    // Mtodo para filtrar incidencias utilizando polimorfismo
    public ArrayList<Incidencia> filtrarIncidencias(FiltroIncidencias filtro) {
        return filtro.filtrar();
    }
}