package com.alilopez.application.controllers;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.alilopez.application.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class InfoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button atrasBttn;

    @FXML
    private Button solicitarBttn;

    @FXML
    void onClickedAtras(MouseEvent event) {
        App.newStage("Administra-view","ADMINISTRADORA");
    }

    @FXML
    void onClickedSolicitar(MouseEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmar solicitud");
        alert.setHeaderText(null);
        alert.setContentText("¿Desea solicitar?");

        ButtonType buttonTypeAceptar = new ButtonType("Aceptar");
        ButtonType buttonTypeCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeAceptar, buttonTypeCancelar);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeAceptar){
            System.out.println("Solicitud Solicitada");
        } else {
            System.out.println("Solicitud cancelada");
        }
    }

    @FXML
    void initialize() {
        assert atrasBttn != null : "fx:id=\"atrasBttn\" was not injected: check your FXML file 'info-view.fxml'.";
        assert solicitarBttn != null : "fx:id=\"solicitarBttn\" was not injected: check your FXML file 'info-view.fxml'.";
    }

}
