package com.alilopez.application.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class BuscarController {
    @FXML
    private TextField txtBuscar;

    @FXML
    private ListView<String> listaResultados;

    private ObservableList<String> datos = FXCollections.observableArrayList(
            "        Nombre:                        Tipo del Objeto:              Color:                          Descripcion del Objeto:                      Aula:             Ud:          Fecha:  ",
            "Nombre:Celular       Tipo del Objeto:Tecnologia       Color:Negro           Descripcion del Objeto:Es de marca Samsung        Aula:16      Ud:3      Fecha: 19/03/2024 ",
            "Nombre:Tablet        Tipo del Objeto:Tecnologia       Color:Azul            Descripcion del Objeto:Es de marca Lg             Aula:20      Ud:1       Fecha: 07/03/2024 ",
            "Nombre:Botella       Tipo del Objeto:Bebida           Color:Amarillo        Descripcion del Objeto:Tiene popote color blanco  Aula:7       Ud:1       Fecha: 02/04/2024 ",
            "Nombre:Lapiz         Tipo del Objeto:Utiles           Color:Naranja         Descripcion del Objeto:Tiene borrador azul        Aula:9       Ud:3       Fecha: 05/04/2024 ",
            "Nombre:Reloj         Tipo del Objeto:Tecnologia       Color:Negro           Descripcion del Objeto:Contiene brillos           Aula:12      Ud:1       Fecha: 01/02/2024 ",
            "Nombre:Gorra         Tipo del Objeto:Personal         Color:Roja            Descripcion del Objeto:Tiene una estrella         Aula:4       Ud:1       Fecha: 23/03/2024 ",
            "Nombre:Collar        Tipo del Objeto:Personal         Color:Dorado          Descripcion del Objeto:Es de un corazon           Aula:19      Ud:1       Fecha: 09/04/2024 "
    );

    @FXML
    public void initialize() {
        listaResultados.setItems(datos);
    }

    @FXML
    public void buscar() {
        String busqueda = txtBuscar.getText().toLowerCase();
        ObservableList<String> resultados = FXCollections.observableArrayList();

        for (String elemento : datos) {
            if (elemento.toLowerCase().contains(busqueda)) {
                resultados.add(elemento);
            }
        }
        listaResultados.setItems(resultados);
    }
}
