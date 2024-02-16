package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ManageUserController {

    @FXML
    private Button buttonConfirm;

    @FXML
    private CheckBox checkBox;

    @FXML
    private Label idUser;

    @FXML
    private TextField labelCep;

    @FXML
    private TextField labelCity;

    @FXML
    private TextField labelNeighborhood;

    @FXML
    private TextField labelNumber;

    @FXML
    private TextField labelPhone;

    @FXML
    private TextField labelPin;

    @FXML
    private TextField labelState;

    @FXML
    private TextField labelStreet;

    @FXML
    private AnchorPane sceneManageUser;

    @FXML
    private Label userName;

    @FXML
    void confirmAction(ActionEvent event) {
        // essa tela precisa saber quem é o usuario a ser alterado

        if (checkBox.isSelected()) {

        } else {

        }

    }

}
