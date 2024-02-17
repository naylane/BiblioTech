package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.Main;


import java.net.URL;
import java.util.ResourceBundle;

public class BookResultsController implements Initializable {

    @FXML
    private ImageView buttonBack;

    @FXML
    private Button buttonSearch;

    @FXML
    private VBox vBox;

    @FXML
    private ChoiceBox<String> choiceBox;
    private String[] position = {"Nome", "Autor", "Categoria", "ISBN"};

    @FXML
    void SearchBook(ActionEvent event) {

    }

    @FXML
    void goBack(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(position);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/campoLivroTest.fxml"));
            AnchorPane novo = fxmlLoader.load();
            vBox.getChildren().add(novo);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}


