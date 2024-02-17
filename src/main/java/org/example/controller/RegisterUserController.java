package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.example.model.Adm;
import org.example.model.Residence;
import org.example.util.AdmHolder;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterUserController implements Initializable {

    @FXML
    private Button buttonConfirm;

    @FXML
    private TextField cepField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField neighborhoodField;

    @FXML
    private TextField numberField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField pinField;

    @FXML
    private TextField stateField;

    @FXML
    private TextField streetField;

    @FXML
    private ChoiceBox<String> choiceBox;

    private String[] position = {"Leitor", "Blibiotecário", "Administrador"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(position);
    }

    @FXML
    void confirmAction(ActionEvent event) {
        try {
            Adm adm = AdmHolder.getInstance().getAdm();

            String name = nameField.getText();
            String pin = pinField.getText();
            String phone = phoneField.getText();
            String state = stateField.getText();
            String city = cityField.getText();
            String neighborhood = neighborhoodField.getText();
            String street = streetField.getText();
            int number = Integer.parseInt(numberField.getText());
            String cep = cepField.getText();

            Residence address = new Residence(state, city, neighborhood, street, number, cep);

            if (choiceBox.getValue().equals("Leitor")) {
                adm.creatReader(name, pin, phone, address);
            } else if (choiceBox.getValue().equals("Blibiotecário")) {
                adm.creatLibrariam(name, pin, phone, address);
            } else if (choiceBox.getValue().equals("Administrador")) {
                adm.creatAdm(name, pin, phone, address);
            } else if (choiceBox.getValue().isEmpty()) {
                // nada selecionado
                System.out.println("KK");
            }
        } catch (Exception e) {
            //
        }
    }

}
