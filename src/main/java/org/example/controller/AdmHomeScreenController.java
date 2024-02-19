package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;
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
        try {
            //Este trecho obtém o palco atual (tela de login) a partir do evento gerado pelo botão de login
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //fecha a tela home, que é a tela atual
            currentScreen.close();

            //pegando o caminho
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/view/bookResultsAdm-view.fxml"));
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
        }
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
