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

    @FXML
    void toHomeAdm(MouseEvent event) throws IOException {
        // fecha a tela atual
        Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentScreen.close();
        // carrega nova tela
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/view/homeAdm-view.fxml"));
        Parent login = loader.load();
        Scene scene = new Scene(login);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
