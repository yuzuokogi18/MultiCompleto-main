package com.alilopez.application;

import com.alilopez.application.models.Usuario;
import com.alilopez.application.models.HistorialIncidencia;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import java.io.IOException;
import java.util.ArrayList;

public class App extends Application {

    private static Stage stageView;
    private static Stage stageRoot;
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static HistorialIncidencia historialIncidencia = new HistorialIncidencia(); // awui nstancie HistorialIncidencia

    @Override
    public void start(Stage stage) throws IOException {
        stageRoot = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("Objetos Perdidos - Home");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void newStage(String fxml, String title) {
        stageView = new Stage();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stageView.setTitle(title);
            stageView.setScene(scene);
            stageView.centerOnScreen();
            stageView.initOwner(stageRoot);
            stageView.initModality(Modality.APPLICATION_MODAL);
            stageView.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Stage getStageView() {
        return stageView;
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        Usuario admin = new Usuario("Admin", "111111", 111111, "admin@upchiapas.ids", 1);
        usuarios.add(admin);
        Usuario alumnoPrueba = new Usuario("", "250", 123456, "proyecto@gmail.com", 2);
        usuarios.add(alumnoPrueba);

        launch(args);
    }

    public static void buscarIncidencia() {
    }

    public static void añadirIncidencia() {
        // Método para añadir incidencias
    }

    public static void eliminarIncidencia() {
    }

    public static void buscarSolicitud() {
    }

    public static void añadirSolicitud() {
    }

    public static void eliminarSolicitud() {
    }

    public static void iniciarSesion(String matricula) {
        boolean isAdmin = false;

        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula() == 111111) {
                isAdmin = true;
                break;
            }
        }

        if (isAdmin && matricula.equals("111111")) {
            newStage("Administra-view", "ADMINISTRADORA");
        } else {
            System.out.println("La matrícula no pertenece al administrador");
        }
    }
}
