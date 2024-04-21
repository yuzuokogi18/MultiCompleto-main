package com.alilopez.application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.alilopez.application.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ValidarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button atrasBttn;

    @FXML
    private Button solicitarBttn;

    @FXML
    void onClickedAceptar(MouseEvent event) {
        System.out.println("Solicitud aceptada. Devolver objeto.");
    }

    @FXML
    void onClickedAtras(MouseEvent event) {
        App.newStage("Administra-view","ADMINISTRADORAS");

    }

    @FXML
    void onClickedCancelar(MouseEvent event) {
        System.out.println("Solicitud cancelada.");
    }

    @FXML
    void initialize() {
        assert atrasBttn != null : "fx:id=\"atrasBttn\" was not injected: check your FXML file 'validar-view.fxml'.";
        assert solicitarBttn != null : "fx:id=\"solicitarBttn\" was not injected: check your FXML file 'validar-view.fxml'.";

    }

}
