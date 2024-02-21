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

public class HomeAdmController {

    @FXML
    private Button buttonBooks;

    @FXML
    private Button buttonCount;

    @FXML
    private Button buttonGoOut;

    @FXML
    private Button buttonHome;

    @FXML
    private AnchorPane sceneHomeAdm;

    public void initialize() throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/admHomeScreen-view.fxml");
    }

    @FXML
    void backHome(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/admHomeScreen-view.fxml");
    }

    @FXML
    void openBooks(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/allBooks-view.fxml");
    }

    @FXML
    void openCount(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/admAccount-view.fxml");
    }

    @FXML
    void openManageBook(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/manageBook-view.fxml");
    }

    @FXML
    void openManageUser(ActionEvent event) throws IOException {
        new SceneSwitch(sceneHomeAdm, "view/manageUser-view.fxml");
    }

    @FXML
    void goOut(ActionEvent event) {
        try{
            //Este trecho obtém o palco atual (tela de login) a partir do evento gerado pelo botão de login
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //fecha a tela home, que é a tela atual
            currentScreen.close();

            //pegando o caminho
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/view/home-view.fxml"));
            Parent login = loader.load(); //carregando o arquivo
            //System.out.println("chega ak 1");
            Stage registerStage = new Stage();
            //cria cena
            Scene scene = new Scene(login);
            //System.out.println("chega ak 2");
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

}