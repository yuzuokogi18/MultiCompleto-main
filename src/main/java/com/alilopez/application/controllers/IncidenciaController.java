package com.alilopez.application.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.alilopez.application.App;
import com.alilopez.application.models.Incidencia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class IncidenciaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AtrasBttn;

    @FXML
    private TextField DescripcionobjetoCasilla;

    @FXML
    private Button GenerarreporteBttn;

    @FXML
    private ChoiceBox<String> aulaCasilla;

    @FXML
    private DatePicker calendarioCasilla;

    @FXML
    private Button cancelarBttn;

    @FXML
    private ColorPicker colorCasilla;

    @FXML
    private Button modificarBttn;

    @FXML
    private TextField nombreobjetoCasilla;

    @FXML
    private TextField tipoCasilla;

    @FXML
    private ChoiceBox<String> udCasilla;

    @FXML
    private Button imagenbtton;

    @FXML
    private ImageView imgView01;

    private ArrayList<Incidencia> incidencias = new ArrayList<>();
    private boolean reporteGenerado = false;

    @FXML
    void guardarTipo(ActionEvent event) {

    }

    @FXML
    void guardardescripcion(ActionEvent event) {

    }

    @FXML
    void mostrarcalendarioClicked(MouseEvent event) {

    }

    @FXML
    void onClickedAtrasFormulario(MouseEvent event) {
        App.newStage("menu-view", "MENU");
    }

    @FXML
    void onClickedCancelar(MouseEvent event) {

    }

    @FXML
    void añadirimagen(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter fileExtensionFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
        fileChooser.setTitle("Select a file");
        fileChooser.getExtensionFilters().add(fileExtensionFilter);
        File filePNG = fileChooser.showOpenDialog(new Stage());
        if (filePNG != null) {
            System.out.println(filePNG.getAbsolutePath());
            FileInputStream image = null;
            try {
                image = new FileInputStream(filePNG.getAbsolutePath());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            imgView01.setImage(new Image(image));
        } else {
            System.out.println("No selecciono ninguna imagen");
        }
    }




    @FXML
    void onClickedGenerarReporte(MouseEvent event) {
        if (camposVacios()) {
            mostrarAlerta("Campos Vacíos", "Por favor, complete todos los campos.");
        } else {
            String descripcion = DescripcionobjetoCasilla.getText();
            String nombreObjeto = nombreobjetoCasilla.getText();
            String tipo = tipoCasilla.getText();
            String aula = aulaCasilla.getValue();
            String ud = udCasilla.getValue();
            String color = colorCasilla.getValue().toString();
            String fecha = calendarioCasilla.getValue().toString();

            Incidencia nuevaIncidencia = new Incidencia(descripcion, nombreObjeto, tipo, aula, ud, color, fecha);
            incidencias.add(nuevaIncidencia);

            reporteGenerado = true;
            deshabilitarCasillas();

            agregarIncidenciaArray(nuevaIncidencia);

            mostrarAlerta("Registro Exitoso", "La incidencia se registró correctamente.");

            imprimirIncidenciasArray();
        }
    }

    @FXML
    void onClickedModificar(MouseEvent event) {
        habilitarCasillas();
    }

    private void habilitarCasillas() {
        DescripcionobjetoCasilla.setEditable(true);
        nombreobjetoCasilla.setEditable(true);
        tipoCasilla.setEditable(true);
        aulaCasilla.setDisable(false);
        udCasilla.setDisable(false);
        colorCasilla.setDisable(false);
        calendarioCasilla.setDisable(false);
    }

    @FXML
    void onclickedAula(MouseEvent event) {

    }

    @FXML
    void onclickedColor(MouseEvent event) {

    }

    @FXML
    void onclickedUD(MouseEvent event) {

    }

    @FXML
    void onguardarnombreObjeto(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AtrasBttn != null : "fx:id=\"AtrasBttn\" was not injected: check your FXML file 'incidencia-view.fxml'.";
        assert DescripcionobjetoCasilla != null : "fx:id=\"DescripcionobjetoCasilla\" was not injected: check your FXML file 'incidencia-view.fxml'.";
        assert GenerarreporteBttn != null : "fx:id=\"GenerarreporteBttn\" was not injected: check your FXML file 'incidencia-view.fxml'.";
        assert aulaCasilla != null : "fx:id=\"aulaCasilla\" was not injected: check your FXML file 'incidencia-view.fxml'.";
        assert calendarioCasilla != null : "fx:id=\"calendarioCasilla\" was not injected: check your FXML file 'incidencia-view.fxml'.";
        assert cancelarBttn != null : "fx:id=\"cancelarBttn\" was not injected: check your FXML file 'incidencia-view.fxml'.";
        assert colorCasilla != null : "fx:id=\"colorCasilla\" was not injected: check your FXML file 'incidencia-view.fxml'.";
        assert modificarBttn != null : "fx:id=\"modificarBttn\" was not injected: check your FXML file 'incidencia-view.fxml'.";
        assert nombreobjetoCasilla != null : "fx:id=\"nombreobjetoCasilla\" was not injected: check your FXML file 'incidencia-view.fxml'.";
        assert tipoCasilla != null : "fx:id=\"tipoCasilla\" was not injected: check your FXML file 'incidencia-view.fxml'.";
        assert udCasilla != null : "fx:id=\"udCasilla\" was not injected: check your FXML file 'incidencia-view.fxml'.";

        for (int i = 1; i <= 20; i++) {
            aulaCasilla.getItems().add(String.valueOf(i));
        }
        udCasilla.getItems().addAll("1", "3");

        colorCasilla.setOnAction(event -> {
            System.out.println("Color seleccionado: " + colorCasilla.getValue().toString());
        });
    }

    private boolean camposVacios() {
        return DescripcionobjetoCasilla.getText().isEmpty() || nombreobjetoCasilla.getText().isEmpty()
                || tipoCasilla.getText().isEmpty() || aulaCasilla.getValue() == null || udCasilla.getValue() == null
                || colorCasilla.getValue() == null || calendarioCasilla.getValue() == null;
    }

    private void deshabilitarCasillas() {
        DescripcionobjetoCasilla.setEditable(false);
        nombreobjetoCasilla.setEditable(false);
        tipoCasilla.setEditable(false);
        aulaCasilla.setDisable(true);
        udCasilla.setDisable(true);
        colorCasilla.setDisable(true);
        calendarioCasilla.setDisable(true);
    }

    private ArrayList<Incidencia> incidenciasArray = new ArrayList<>();

    // ADD incidenciE al array agreguemos aqui esto adrian
    private void agregarIncidenciaArray(Incidencia incidencia) {
        incidenciasArray.add(incidencia);
    }

    // GET arrey de incidencias
    public ArrayList<Incidencia> getIncidenciasArray() {
        return incidenciasArray;
    }

    private void imprimirIncidenciasArray() {
        System.out.println("Incidencias:");
        for (Incidencia incidencia : incidenciasArray) {
            //System.out.println("Nombre del objeto: " + incidencia.getNombreObjeto());
            System.out.println("Tipo: " + incidencia.getTipo());
            System.out.println("Color: " + incidencia.getColor());
            System.out.println("Descripción: " + incidencia.getDescripcion());
            //System.out.println("Aula: " + incidencia.getAula());
            //System.out.println("Ud: " + incidencia.getUd());
            System.out.println("Fecha: " + incidencia.getFecha());
            System.out.println("-----------------------------------------");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

