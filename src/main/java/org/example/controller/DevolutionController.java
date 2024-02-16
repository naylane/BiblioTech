package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DevolutionController {

    @FXML
    private Button buttonRegisterDevolution;

    @FXML
    private ImageView goBack;

    @FXML
    private TextField labelLoan;

    @FXML
    private TextField labelReader;

    @FXML
    void registerDevolution(ActionEvent event) {
        // chamar o bibliotecario logando para registrar
    }

}
