package com.alilopez.application.models;

import java.util.ArrayList;

public abstract class FiltroIncidencias {
    protected ArrayList<Incidencia> listaIncidencias;

    public FiltroIncidencias(ArrayList<Incidencia> listaIncidencias) {
        this.listaIncidencias = listaIncidencias;
    }

    public abstract ArrayList<Incidencia> filtrar();
}