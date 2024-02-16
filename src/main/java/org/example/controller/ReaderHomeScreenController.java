package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ReaderHomeScreenController implements Initializable {

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
    private Label nameLabel;

    @FXML
    private AnchorPane sceneHomeReader;

    @FXML
    private TextField searchField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.nameLabel.setText(ReaderHolder.getInstance().getReader().getName());
    }

    @FXML
    void searchBook(ActionEvent event) {

    }

    @FXML
    void selectAuthor(ActionEvent event) {

    }

    @FXML
    void selectCategory(ActionEvent event) {

    }

    @FXML
    void selectISBN(ActionEvent event) {

    }

    @FXML
    void selectTitulo(ActionEvent event) {

    }

}
