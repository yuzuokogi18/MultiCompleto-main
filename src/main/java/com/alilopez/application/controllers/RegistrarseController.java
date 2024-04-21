package com.alilopez.application.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.alilopez.application.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class RegistrarseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AltaBttn;

    @FXML
    private CheckBox clickRecordarme;

    @FXML
    private Button closeButton;

    @FXML
    private PasswordField contra1Casilla;

    @FXML
    private PasswordField contra2Casilla;

    @FXML
    private TextField correoCasilla;

    @FXML
    private ComboBox<Integer> cuatriCasilla;

    @FXML
    private TextField matriculaCasilla;

    @FXML
    private TextField nombreCasilla;

    private static final int MAX_MATRICULA_LENGTH = 6;

    public static ArrayList<String> listaUsuarios = new ArrayList<>();

    private int conteoRegistros = 0;

    @FXML
    void onClickCloseButton(MouseEvent event) {
        App.newStage("home-view", "HOME");
    }

    @FXML
    void onClickRecordarme(MouseEvent event) {
        if (clickRecordarme.isSelected()) {
            String nombreRecordado = nombreCasilla.getText();
            String correoRecordado = correoCasilla.getText();
            String matriculaRecordada = matriculaCasilla.getText();
            String contra1Recordada = contra1Casilla.getText();
            String contra2Recordada = contra2Casilla.getText();
            String cuatriRecordado = String.valueOf(cuatriCasilla.getValue());
        }
    }

    @FXML
    void onClickedDarsedeAlta(MouseEvent event) {
        String nombre = nombreCasilla.getText();
        String correo = correoCasilla.getText();
        String matricula = matriculaCasilla.getText();
        String contra1 = contra1Casilla.getText();
        String contra2 = contra2Casilla.getText();
        Integer cuatri = cuatriCasilla.getValue();

        if (nombre.isEmpty() || correo.isEmpty() || matricula.isEmpty() || contra1.isEmpty() || contra2.isEmpty() || cuatri == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos Vacíos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, llene todos los campos.");
            alert.showAndWait();
        } else if (!contra1.equals(contra2)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Contraseñas No Coinciden");
            alert.setHeaderText(null);
            alert.setContentText("Las contraseñas no coinciden. Por favor, verifique.");
            alert.showAndWait();
        } else {
            StringBuilder puntos = new StringBuilder();
            for (int i = 0; i < contra1.length(); i++) {
                puntos.append("•");
            }
            String mensaje = "¡El registro ha sido exitoso!\n\n"
                    + "Nombre: " + nombre + "\n"
                    + "Matrícula: " + matricula + "\n"
                    + "Correo: " + correo + "\n"
                    + "Cuatrimestre: " + cuatri + "\n"
                    + "Contraseña: " + puntos.toString() + "\n";

            System.out.println("Registro exitoso:");
            System.out.println(mensaje);

            conteoRegistros++;

            String usuario = "Registro " + conteoRegistros + "\nNombre: " +
                    nombre + "\nMatrícula: " +
                    matricula + "\nCorreo: " + correo + "\nCuatrimestre: " + cuatri + "\nContraseña: " + puntos.toString();
            listaUsuarios.add(usuario);

            System.out.println("ListaUsuarios:");
            for (int i = 0; i < listaUsuarios.size(); i++) {
                System.out.println(listaUsuarios.get(i) + "\n");
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registro Exitoso");
            alert.setHeaderText(null);

            Label contentLabel = new Label(mensaje);
            contentLabel.setAlignment(Pos.CENTER);
            contentLabel.setMaxWidth(Double.MAX_VALUE);
            contentLabel.setWrapText(true);

            alert.getDialogPane().setContent(contentLabel);

            alert.setResizable(true);
            alert.getDialogPane().setPrefSize(1280, 700);

            alert.setOnCloseRequest(e -> {
                App.newStage("home-view", "HOME");
            });

            alert.showAndWait();
        }
    }

    @FXML
    void onGuardarContra1(ActionEvent event) {

    }

    @FXML
    void onGuardarContra2(ActionEvent event) {

    }

    @FXML
    void onGuardarCorreo(ActionEvent event) {
        String input = correoCasilla.getText();
        if (!input.endsWith("@ids.upchiapas.edu.mx")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Correo Inválido");
            alert.setHeaderText(null);
            alert.setContentText("Ingrese un correo válido de la institución.");
            alert.showAndWait();
            correoCasilla.clear();
        }
    }

    @FXML
    void onGuardarCuatri(ActionEvent event) {

    }

    @FXML
    void onGuardarMatricula(ActionEvent event) {
        String input = matriculaCasilla.getText().trim();

        if (input.matches("\\d{1,6}")) {
            matriculaCasilla.setText(input);
        } else {
            matriculaCasilla.clear();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Formato de Matrícula Incorrecto");
            alert.setHeaderText(null);
            alert.setContentText("La matrícula debe contener solo 6 dígitos numéricos.");
            alert.showAndWait();
        }
    }

    @FXML
    void onGuardarNombre(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AltaBttn != null : "fx:id=\"AltaBttn\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert clickRecordarme != null : "fx:id=\"clickRecordarme\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert contra1Casilla != null : "fx:id=\"contra1Casilla\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert contra2Casilla != null : "fx:id=\"contra2Casilla\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert correoCasilla != null : "fx:id=\"correoCasilla\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert cuatriCasilla != null : "fx:id=\"cuatriCasilla\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert matriculaCasilla != null : "fx:id=\"matriculaCasilla\" was not injected: check your FXML file 'registrarse-view.fxml'.";
        assert nombreCasilla != null : "fx:id=\"nombreCasilla\" was not injected: check your FXML file 'registrarse-view.fxml'.";

        cuatriCasilla.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        matriculaCasilla.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0," + MAX_MATRICULA_LENGTH + "}")) {
                matriculaCasilla.setText(oldValue);
            }
        });

        // adrian le agregue este que es un lambda define lo que sucederá cuando cambie el valor de la propiedad enfocada eso dice
        correoCasilla.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                onGuardarCorreo(null);
            }
        });
    }
}
