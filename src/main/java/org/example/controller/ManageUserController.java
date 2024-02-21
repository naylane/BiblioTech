package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.dao.DAO;
import org.example.model.Reader;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageUserController implements Initializable {

    @FXML
    private CheckBox blockCheckBox;

    @FXML
    private Button buttonConfirm;

    @FXML
    private TextField cepField;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextField cityField;

    @FXML
    private TextField idField;

    @FXML
    private Label idLabel;

    @FXML
    private Label messageAlert;

    @FXML
    private TextField nameField;

    @FXML
    private TextField neighborhoodField;

    @FXML
    private TextField numberField;

    @FXML
    private Button okButton;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField pinField;

    @FXML
    private AnchorPane sceneManageUser;

    @FXML
    private TextField stateField;

    @FXML
    private TextField streetField;

    private String[] position = {"Leitor", "Blibiotecário", "Administrador"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(position);
    }

    @FXML
    void confirmAction(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {
        try {
            if (choiceBox.getValue().equals("Leitor")) {
                System.out.println("1"); // ok
                long id = Long.parseLong(idField.getText());
                Reader reader = DAO.getReaderDAO().findById(id);
                System.out.println("2");
                System.out.println(reader);
                idLabel.setText("CC");
                System.out.println("3");
            }
        } catch (Exception e) {
            //
        }
    }

}
