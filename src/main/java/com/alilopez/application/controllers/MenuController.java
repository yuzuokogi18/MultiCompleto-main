package com.alilopez.application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.alilopez.application.App;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BuscarBttn;

    @FXML
    private Button IncidenciasBttn;

    @FXML
    private Button ReporteUsuario;

    @FXML
    private Button UsuarioBttn;

    @FXML
    private Button actualizarBttn;

    @FXML
    private Button enseñarListaIncidencias;

    @FXML
    void onClickedBuscar(MouseEvent event) {
        App.newStage("buscar-view","BUSCAR");

    }

    @FXML
    void onClickedIncidencia(MouseEvent event) {
        App.newStage("incidencia-view","INCIDENCIAS");

    }

    @FXML
    void onClickedReporte(MouseEvent event) {
        App.newStage("reporte-view","REPORTE");

    }


    @FXML
    void onClickedTabla(MouseEvent event) {


    }

    @FXML
    void onclickedactualizar(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setY(stage.getY() - 50);
    }

    @FXML
    void onclickedmostrarlista(MouseEvent event) {
        App.newStage("lista-view","LISTAS");

    }

    @FXML
    void initialize() {
        assert BuscarBttn != null : "fx:id=\"BuscarBttn\" was not injected: check your FXML file 'menu-view.fxml'.";
        assert IncidenciasBttn != null : "fx:id=\"IncidenciasBttn\" was not injected: check your FXML file 'menu-view.fxml'.";
        assert ReporteUsuario != null : "fx:id=\"ReporteUsuario\" was not injected: check your FXML file 'menu-view.fxml'.";
        assert UsuarioBttn != null : "fx:id=\"UsuarioBttn\" was not injected: check your FXML file 'menu-view.fxml'.";
        assert actualizarBttn != null : "fx:id=\"actualizarBttn\" was not injected: check your FXML file 'menu-view.fxml'.";
        assert enseñarListaIncidencias != null : "fx:id=\"enseñarListaIncidencias\" was not injected: check your FXML file 'menu-view.fxml'.";

    }


}
