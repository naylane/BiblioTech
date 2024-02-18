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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeAdmController implements Initializable {

    @FXML
    private Button buttonAllUsers;

    @FXML
    private Button buttonCount;

    @FXML
    private Button buttonGoOut;

    @FXML
    private Button buttonDevolutions;

    @FXML
    private Button buttonBooks;

    @FXML
    private Button buttonHome;

    @FXML
    private Button buttonLoan;

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
    private Button buttonTitulo;

    @FXML
    private Button buttonTitulo1;

    @FXML
    private Button buttonTitulo11;

    @FXML
    private Button buttonTitulo12;

    @FXML
    private AnchorPane sceneHomeAdm;

    @FXML
    private Pane paneReport;

    @FXML
    private Button registerDevolution;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            new SceneSwitch(sceneHomeAdm, "view/admHomeScreen-view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void SearchBook(ActionEvent event) {

    }

    @FXML
    void SelectTitulo(ActionEvent event) {

    }

    @FXML
    void backHome(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/admHomeScreen-view.fxml");
    }

    @FXML
    void goOut(ActionEvent event) {
        try {
            // Este trecho obtém o palco atual a partir do evento gerado pelo botão
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentScreen.close(); // fecha a tela atual

            // pegando o caminho
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/view/home-view.fxml"));
            Parent login = loader.load(); // carregando o arquivo
            Stage registerStage = new Stage();
            Scene scene = new Scene(login); // cria cena
            registerStage.setResizable(false); // não permite que a tela seja redmensionada
            // exibição da tela
            registerStage.setScene(scene);
            registerStage.show();
            //define um icone para tela login
            registerStage.getIcons().add(new Image(getClass().getResourceAsStream("/org/example/view/images/symbol.png")));
            registerStage.setTitle("BiblioTech Home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openCount(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/admAccount-view.fxml");
    }

    @FXML
    void openLoan(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/allLoans-view.fxml");
    }

    @FXML
    void openDevolutions(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/allDevolutions-view.fxml");
    }

    @FXML
    void buttonBooks(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/allBooks-view.fxml");

    }


}
