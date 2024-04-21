package com.alilopez.application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.alilopez.application.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class ListaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void accion2Handler(ActionEvent event) {

    }

    @FXML
    void accion3Handler(ActionEvent event) {

    }

    @FXML
    void accion4Handler(ActionEvent event) {

    }

    @FXML
    void actionreloj(ActionEvent event) {

    }

    @FXML
    void onClickedAnilla(MouseEvent event) {
        App.newStage("anilla-view","ANILLA");

    }

    @FXML
    void onClickedBilletera(MouseEvent event) {
        App.newStage("billetera-view","BILLETERA");

    }

    @FXML
    void onClickedCelular(MouseEvent event) {
        App.newStage("celular-view","CELULAR");

    }

    @FXML
    void onClickedLlave(MouseEvent event) {
        App.newStage("llave-view","LLAVE");

    }

    @FXML
    void onClickedReloj(MouseEvent event) {
        App.newStage("info-view","INFORMACION");

    }

    @FXML
    void initialize() {

    }

}
