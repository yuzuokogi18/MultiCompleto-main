package com.alilopez.application.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import com.alilopez.application.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox ClickRecordarmr;

    @FXML
    private Button IngresarButtonIniciarSes;

    @FXML
    private Button atrasButtonIniciarSes;

    @FXML
    private Button closeButton;

    @FXML
    private PasswordField contra1Casilla;

    @FXML
    private TextField matriculaCasilla;

    @FXML
    void onClickCerrar(MouseEvent event) {
    }

    @FXML
    void onClickClAtras(MouseEvent event) {
        App.newStage("home-view", "HOME");
    }


    @FXML
    void onClickClIngresar(MouseEvent event) {
        String matricula = matriculaCasilla.getText();

        if (matricula.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campo Vacío");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, ingrese la matrícula.");
            alert.showAndWait();
        } else if (!Pattern.matches("\\d{6}", matricula)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Formato Incorrecto");
            alert.setHeaderText(null);
            alert.setContentText("La matrícula debe contener exactamente 6 números.");
            alert.showAndWait();
        } else {
            boolean usuarioRegistrado = false;
            for (String usuario : RegistrarseController.listaUsuarios) {
                if (usuario.contains(matricula)) {
                    usuarioRegistrado = true;
                    break;
                }
            }
            if (matricula.equals("111111")) {
                App.newStage("Administra-view", "ADMINISTRADORA");
            } else if (usuarioRegistrado) {
                App.newStage("menu-view", "MENU");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Usuario no registrado");
                alert.setHeaderText(null);
                alert.setContentText("La matrícula ingresada no está registrada.");
                alert.showAndWait();
            }
        }
    }


    @FXML
    void onGuardarContra(ActionEvent event) {
    }

    @FXML
    void onGuardarMatricula(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert ClickRecordarmr != null : "fx:id=\"ClickRecordarmr\" was not injected: check your FXML file 'client-view.fxml'.";
        assert IngresarButtonIniciarSes != null : "fx:id=\"IngresarButtonIniciarSes\" was not injected: check your FXML file 'client-view.fxml'.";
        assert atrasButtonIniciarSes != null : "fx:id=\"atrasButtonIniciarSes\" was not injected: check your FXML file 'client-view.fxml'.";
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'client-view.fxml'.";
        assert contra1Casilla != null : "fx:id=\"contra1Casilla\" was not injected: check your FXML file 'client-view.fxml'.";
        assert matriculaCasilla != null : "fx:id=\"matriculaCasilla\" was not injected: check your FXML file 'client-view.fxml'.";

        matriculaCasilla.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                matriculaCasilla.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (newValue.length() > 6) {
                String limitedValue = newValue.substring(0, 6);
                matriculaCasilla.setText(limitedValue);
            }
        });
    }
}
