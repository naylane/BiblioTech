package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import org.example.util.AdmHolder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdmHomeScreenController implements Initializable {

    @FXML
    private Button buttonAllUsers;

    @FXML
    private Button buttonRegisterBook;

    @FXML
    private Button buttonRegisterLoan;

    @FXML
    private Button buttonRegisterUser;

    @FXML
    private Button buttonReport;

    @FXML
    private Button buttonSearch;

    @FXML
    private Button registerDevolution;

    @FXML
    private Label nameLabel;

    @FXML
    private AnchorPane sceneHomeAdm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.nameLabel.setText(AdmHolder.getInstance().getAdm().getName());
    }

    @FXML
    void SearchBook(ActionEvent event) {

    }

    @FXML
    void SelectTitulo(ActionEvent event) {

    }

    @FXML
    void openRegisterBook(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/registerBook-view.fxml");
    }

    @FXML
    void openRegisterDevolution(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/registerDevolution-view.fxml");
    }

    @FXML
    void openRegisterLoan(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/registerLoan-view.fxml");
    }

    @FXML
    void openReport(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/report-view.fxml");
    }

    @FXML
    void registerNewUser(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/registerUser-view.fxml");
    }

    @FXML
    void openAllUsers(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/allUsers-view.fxml"); // NAO VAI
    }
}
