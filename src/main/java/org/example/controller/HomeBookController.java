package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeBookController {

    @FXML
    private Label LabelCategory;

    @FXML
    private Label bookSearched;

    @FXML
    private Label companyL;

    @FXML
    private Button giveBack;

    @FXML
    private Button goBack;

    @FXML
    private Label hall;

    @FXML
    private Label isbn;

    @FXML
    private Label labelAuthor;

    @FXML
    private Label labelQntAval;

    @FXML
    private Label labelQntTotal;

    @FXML
    private Button renew;

    @FXML
    private Button reserve;

    @FXML
    private Label section;

    @FXML
    private Label shelf;

    @FXML
    private Label title;

    @FXML
    private Button toLoan;

    @FXML
    private Label yearLabel;

    @FXML
    void goBack(ActionEvent event) {
        // retorna para a página anterior (home de leitor, home de bibliotecario ou home de adm)
    }

    @FXML
    void makeLoan(ActionEvent event) {

    }

    @FXML
    void makeRenew(ActionEvent event) {

    }

    @FXML
    void makeReserve(ActionEvent event) {

    }

    @FXML
    void makeReturn(ActionEvent event) {

    }

}
