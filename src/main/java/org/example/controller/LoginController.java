package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Label ID;

    @FXML
    private TextField SenhaField1;

    @FXML
    private Button buttonEntrar;

    @FXML
    private Button buttonHome;

    @FXML
    private TextField idField;

    @FXML
    private Label registerPage;

    @FXML
    private Label senha;

    @FXML
    public void backHome(ActionEvent event) {
        try {
            //Este trecho obtém o palco atual (tela de login) a partir do evento gerado pelo botão de login
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //fecha a tela home, que é a tela atual
            currentScreen.close();

            //pegando o caminho
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/view/home-view.fxml"));
            Parent login = loader.load(); //carregando o arquivo
            Stage registerStage = new Stage();
            //cria cena
            Scene scene = new Scene(login);
            //não permite que a tela seja redmensionada
            registerStage.setResizable(false);
            //exibição da tela
            registerStage.setScene(scene);
            registerStage.show();
            //define um icone para tela login
            registerStage.getIcons().add(new Image(getClass().getResourceAsStream("/org/example/view/images/symbol.png")));
            registerStage.setTitle("BiblioTech Home"); //nome da pag

        } catch (IOException e) {
            e.printStackTrace();
            //System.err.println("Erro ao carregar o arquivo FXML da tela de login: " + e.getMessage());
        }
    }
    @FXML
    public void OpenSystem(ActionEvent actionEvent) {
    }
}

