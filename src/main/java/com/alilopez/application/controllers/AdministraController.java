package com.alilopez.application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.alilopez.application.App;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class AdministraController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button eliminarreporteBttn;

    @FXML
    private Button exitButton;

    @FXML
    private PieChart graficaBttn;

    @FXML
    private Button validarincidenciaBttn;

    @FXML
    private Button verreporteBttn;

    @FXML
    void onMouseClickExitButton(MouseEvent event) {
        Platform.exit();

    }

    @FXML
    void onclickedEliminar(MouseEvent event) {
        App.newStage("eliminar-view","ELIMINAR");

    }

    @FXML
    void onclickedValidarncidencia(MouseEvent event) {
        App.newStage("validar-view","VALIDAR INCIDENCIA");


    }

    @FXML
    void onclickedVerreporte(MouseEvent event) {
        App.newStage("verreporte-view","VER REPORTE");

    }

    @FXML
    void initialize() {
        assert eliminarreporteBttn != null : "fx:id=\"eliminarreporteBttn\" was not injected: check your FXML file 'Administra-view.fxml'.";
        assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'Administra-view.fxml'.";
        assert graficaBttn != null : "fx:id=\"graficaBttn\" was not injected: check your FXML file 'Administra-view.fxml'.";
        assert validarincidenciaBttn != null : "fx:id=\"validarincidenciaBttn\" was not injected: check your FXML file 'Administra-view.fxml'.";
        assert verreporteBttn != null : "fx:id=\"verreporteBttn\" was not injected: check your FXML file 'Administra-view.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Resueltos", 30),
                        new PieChart.Data("Sin resolver", 70)
                );
        graficaBttn.setData(pieChartData);
        graficaBttn.setTitle("Gráfica de incidencias");
    }
}