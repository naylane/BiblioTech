package org.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.example.model.Adm;
import org.example.model.Residence;
import org.example.util.AdmHolder;

import java.net.URL;
import java.util.ResourceBundle;

public class AdmAccountController implements Initializable {

    @FXML
    private Label cepGap;

    @FXML
    private Label cityGap;

    @FXML
    private Label idLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label neighborhoodGap;

    @FXML
    private Label numberHomeGap;

    @FXML
    private Label phoneGap;

    @FXML
    private AnchorPane sceneHomeAdm;

    @FXML
    private Label stateGap;

    @FXML
    private Label streetGap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Adm adm = AdmHolder.getInstance().getAdm();
        Residence address = adm.getAddress();

        nameLabel.setText(adm.getName());
        idLabel.setText(String.valueOf(adm.getId()));
        phoneGap.setText(adm.getPhone());
        stateGap.setText(address.getState());
        cityGap.setText(address.getCity());
        cepGap.setText(address.getCep());
        neighborhoodGap.setText(address.getNeighborhood());
        streetGap.setText(address.getStreet());
        numberHomeGap.setText(String.valueOf(address.getNumber()));
    }

}

