package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LibrarianHomeScreenController {

    @FXML
    private Button buttonRegisterBook;

    @FXML
    private Button buttonRegisterLoan;

    @FXML
    private Button buttonSearch;

    @FXML
    private Button registerDevolution;

    @FXML
    private AnchorPane sceneHomeLibrarian;

    @FXML
    void SearchBook(ActionEvent event) throws IOException {
        try {
            //Este trecho obtém o palco atual (tela de login) a partir do evento gerado pelo botão de login
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //fecha a tela home, que é a tela atual
            currentScreen.close();

            //pegando o caminho
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/view/bookResultsLibrarian-view.fxml"));
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
            registerStage.setTitle("BiblioTech Search"); //nome da pag

        } catch (IOException e) {
            e.printStackTrace();
            //System.err.println("Erro ao carregar o arquivo FXML da tela de login: " + e.getMessage());
        }    }

    @FXML
    void openRegisterBook(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeLibrarian, "view/registerBook-view.fxml");
    }

    @FXML
    void openRegisterDevolution(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeLibrarian, "view/registerDevolution-view.fxml");
    }

    @FXML
    void openRegisterLoan(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeLibrarian, "view/registerLoan-view.fxml");
    }

}
