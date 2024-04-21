package com.alilopez.application.controllers;

import com.alilopez.application.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class ReporteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ColorPicker BttnColor;

    @FXML
    private TextField nombreCasilla;

    @FXML
    private ChoiceBox<String> aulaCasilla;

    @FXML
    private DatePicker calendarCasilla;

    @FXML
    private TextField descripcionCasilla;

    @FXML
    private ComboBox<String> udCasilla;

    private boolean camposHabilitados = true;

    private ArrayList<String> datosSolicitados = new ArrayList<>();

    @FXML
    void guardarAula(MouseEvent event) {

    }

    @FXML
    void guardarColor(ActionEvent event) {

    }

    @FXML
    void guardarDescripcionObjeto(ActionEvent event) {

    }

    @FXML
    void guardarFecha(ActionEvent event) {

    }

    @FXML
    void guardarNombre(ActionEvent event) {

    }

    @FXML
    void guardarTipoObjeto(ActionEvent event) {

    }

    @FXML
    void guardarUd(ActionEvent event) {

    }

    @FXML
    void onClickedAtras(MouseEvent event) {
        App.newStage("menu-view","MENU");
    }

    @FXML
    void onClickedEditar(MouseEvent event) {
        camposHabilitados = true;
        nombreCasilla.setDisable(false);
        descripcionCasilla.setDisable(false);
        aulaCasilla.setDisable(false);
        udCasilla.setDisable(false);
        BttnColor.setDisable(false);
        calendarCasilla.setDisable(false);
    }

    @FXML
    void onClickedSolicitar(MouseEvent event) {
        if (camposHabilitados && (nombreCasilla.getText().isEmpty() || descripcionCasilla.getText().isEmpty() ||
                aulaCasilla.getValue() == null || udCasilla.getValue() == null ||
                BttnColor.getValue() == null || calendarCasilla.getValue() == null)) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos Vacíos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, complete todos los campos.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación de Solicitud");
            alert.setHeaderText("¿Está seguro que desea solicitar este objeto perdido?");
            alert.setContentText("Seleccione 'Aceptar' para confirmar o 'Cancelar' para cancelar.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                camposHabilitados = false;
                nombreCasilla.setDisable(true);
                descripcionCasilla.setDisable(true);
                aulaCasilla.setDisable(true);
                udCasilla.setDisable(true);
                BttnColor.setDisable(true);
                calendarCasilla.setDisable(true);
//aray en donde guarde datos aqui de los reportes
                String datos = "Nombre: " + nombreCasilla.getText()
                        + ", Tipo de objeto: " + descripcionCasilla.getText()
                        + ", Color: " + BttnColor.getValue()
                        + ", Descripción del objeto: " + descripcionCasilla.getText()
                        + ", Aula: " + aulaCasilla.getValue()
                        + ", Ud: " + udCasilla.getValue()
                        + ", Fecha: " + calendarCasilla.getValue();
                datosSolicitados.add(datos);

                System.out.println("Datos del objeto perdido solicitado:");
                for (String dato : datosSolicitados) {
                    System.out.println(dato);
                }
            }
        }
    }

    @FXML
    void initialize() {
        aulaCasilla.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20");

        udCasilla.getItems().addAll("1", "3");
    }

}
