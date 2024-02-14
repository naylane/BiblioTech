package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

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
    private Button buttonGoOut1;

    @FXML
    private Button buttonGoOut2;

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
    private AnchorPane paneDashBoard;

    @FXML
    private Pane paneReport;

    @FXML
    private Button registerDevolution;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void SearchBook(ActionEvent event) {

    }

    @FXML
    void SelectTitulo(ActionEvent event) {

    }

    @FXML
    void backHome(ActionEvent event) {

    }

    @FXML
    void goOut(ActionEvent event) {
    }

    @FXML
    void openAllUsers(ActionEvent event) {

    }

    @FXML
    void openCount(ActionEvent event) {

    }

    @FXML
    void openLoan(ActionEvent event) {

    }

    @FXML
    void openRegisterBook(ActionEvent event) {

    }

    @FXML
    void openRegisterDevolution(ActionEvent event) {

    }

    @FXML
    void openRegisterLoan(ActionEvent event) {

    }

    // muda para a tela do relatório
    @FXML
    void openReport(ActionEvent event) {
        //paneReport.setStyle("-fx-background-color : #fffafa");
        paneReport.toFront();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/view/report-view.fxml"));
            Pane pane1 = loader.load(); {
                paneReport.getChildren().clear();
                paneReport.getChildren().add(pane1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void registerNewUser(ActionEvent event) {

    }
}
