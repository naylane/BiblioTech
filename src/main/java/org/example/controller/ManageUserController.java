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
import org.example.exceptions.UsersException;
import org.example.model.*;
import org.example.util.AdmHolder;

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
    private Button okButton;

    @FXML
    private Label messageAlert;

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
        Adm adm = AdmHolder.getInstance().getAdm();

        String name = nameField.getText();
        String pin = pinField.getText();
        String phone = phoneField.getText();

        String state = stateField.getText();
        String neighborhood = neighborhoodField.getText();
        String street = streetField.getText();
        String city = cityField.getText();
        String cep = cepField.getText();
        int number = Integer.parseInt(numberField.getText());

        Residence residence = new Residence(state, city, neighborhood, street, number, cep);

        try {
            messageAlert.setText("");

            if (choiceBox.getValue().equals("Leitor")) {
                if(idField.getText() == null){
                    messageAlert.setText("O campo de ID é Obrigatório!");}
                else {
                    if (adm.readerSearch(Long.parseLong(idField.getText())) == null) {
                        messageAlert.setText("Esse ID não existe!");
                    } else {
                        Reader reader = new Reader(name, pin, phone, residence, choiceBox.getValue());
                        adm.updateReader(reader);
                    }
                }

            } else if (choiceBox.getValue().equals("Blibiotecário")) {
                if(idField.getText() == null){
                    messageAlert.setText("O campo de ID é Obrigatório!");}
                else {
                    if (adm.librarianSearch(Long.parseLong(idField.getText())) == null) {
                        messageAlert.setText("Esse ID não existe!");
                    } else {
                        Librarian librarian = new Librarian(name, pin, phone, residence, choiceBox.getValue());
                        adm.updateLibrarian(librarian);
                    }
                }

            } else if (choiceBox.getValue().equals("Administrador")) {
                if(idField.getText() == null){
                    messageAlert.setText("O campo de ID é Obrigatório!");}
                else {
                    if (adm.admSearch(Long.parseLong(idField.getText())) == null) {
                        messageAlert.setText("Esse ID não existe!");
                    } else {
                        Adm admUpdate = new Adm(name, pin, phone, residence, choiceBox.getValue());
                        adm.updateAdm(admUpdate);
                    }
                }
            }
            messageAlert.setText("Edição Concluída Com Sucesso!");
        } catch (Exception e) {
            messageAlert.setText("Algo Deu Errado Com A Edição! Verifique os Dados.");
            throw new NullPointerException ();
        }
    }
    @FXML
    void search(ActionEvent event) throws Exception { //refresh
        messageAlert.setText("");
        if(idField.getText() == null){
            messageAlert.setText("Digite um ID!");}
        else{
            if(choiceBox.getValue() == null){
                messageAlert.setText("Escolha um tipo de Conta!");
            }else{
                if(choiceBox.getValue().equals("Leitor")){
                    Adm adm = AdmHolder.getInstance().getAdm();
                    if (adm.readerSearch(Long.parseLong(idField.getText())) == null) {
                        messageAlert.setText("Esse ID não existe!");
                    }else{ //faz o refresh view
                        Reader reader = adm.readerSearch(Integer.parseInt(idField.getText()));

                        nameField.setText(reader.getName());
                        pinField.setText(reader.getPin());
                        phoneField.setText(reader.getPhone());
                        stateField.setText(reader.getAddress().getState());
                        neighborhoodField.setText(reader.getAddress().getNeighborhood());
                        streetField.setText(reader.getAddress().getStreet());
                        cityField.setText(reader.getAddress().getCity());
                        cepField.setText(reader.getAddress().getCep());
                        numberField.setText(Integer.toString(reader.getAddress().getNumber()));
                }}
            }
        }
    }

}
