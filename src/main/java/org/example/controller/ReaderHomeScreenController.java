package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.util.ReaderHolder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReaderHomeScreenController implements Initializable {

    @FXML
    private Button buttonSearch;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Label messageAlert;

    @FXML
    private Label nameLabel;

    @FXML
    private AnchorPane sceneHomeReader;

    @FXML
    private TextField searchField;
    private String[] position = {"Nome", "Autor", "Categoria", "ISBN"};

    @FXML
    void searchBook(ActionEvent event) {
        if(!searchField.getText().isEmpty()){
            if(choiceBox.getValue() != null){
                try {
                    //Este trecho obtém o palco atual (tela de login) a partir do evento gerado pelo botão de login
                    Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    //fecha a tela home, que é a tela atual
                    currentScreen.close();

                    //pegando o caminho
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/view/bookResults-view.fxml"));
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
            }else{messageAlert.setText("Selecione uma opção para pesquisar");}

        }else{messageAlert.setText("Digite algo para pesquisar!");}

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.nameLabel.setText(ReaderHolder.getInstance().getReader().getName());
        choiceBox.getItems().addAll(position);
    }
}
