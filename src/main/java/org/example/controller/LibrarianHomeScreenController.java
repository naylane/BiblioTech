package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LibrarianHomeScreenController {

    @FXML
    private Button buttonRegisterBook;

    @FXML
    private Button buttonRegisterLoan;

    @FXML
    private Button buttonSearch;

    @FXML
    private Button buttonTitulo;

    @FXML
    private Button buttonTitulo1;

    @FXML
    private Button buttonTitulo11;

    @FXML
    private Button buttonTitulo12;

    @FXML
    private Button registerDevolution;

    @FXML
    private AnchorPane sceneHomeLibrarian;

    @FXML
    void SearchBook(ActionEvent event) {

    }

    @FXML
    void SelectTitulo(ActionEvent event) {

    }

    @FXML
    void openRegisterBook(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeLibrarian, "view/registerBook-view.fxml");
    }

    @FXML
    void openRegisterDevolution(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeLibrarian, "view/registerDevolution-view.fxml");
    }

    @FXML
    void openRegisterLoan(ActionEvent event) {
        
    }

}
