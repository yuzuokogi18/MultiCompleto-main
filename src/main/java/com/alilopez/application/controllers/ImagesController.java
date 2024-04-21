package com.alilopez.application.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ImagesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView img;
    @FXML
    private ImageView imgView01;


    @FXML
    private Button btnImagen;

    @FXML
    void onClickedBtn(MouseEvent event) {
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
    void onMouseClickedImage(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmacion");
        alert.showAndWait();
        System.out.println(((ImageView)event.getSource()).toString());
    }

    @FXML
    void initialize() {
        btnImagen.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-weight: 900;");
        img.setFitHeight(300);
        img.setPreserveRatio(true);
        img.setSmooth(true);
        img.setCache(true);
    }

}
