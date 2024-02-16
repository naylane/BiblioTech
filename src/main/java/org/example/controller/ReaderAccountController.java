package org.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import org.example.model.Reader;
import org.example.model.Residence;

public class ReaderAccountController implements Initializable {

    @FXML
    private Label nameLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label activityLoan;

    @FXML
    private Label accountStatus;

    @FXML
    private Label cepGap;

    @FXML
    private Label cityGap;

    @FXML
    private Label neighborhoodGap;

    @FXML
    private Label numberHomeGap;

    @FXML
    private Label phoneGap;

    @FXML
    private AnchorPane sceneHomeReader;

    @FXML
    private Label stateGap;

    @FXML
    private Label streetGap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Reader reader = ReaderHolder.getInstance().getReader();
        Residence address = reader.getAddress();

        nameLabel.setText(reader.getName());
        idLabel.setText(String.valueOf(reader.getId()));
        phoneGap.setText(reader.getPhone());
        stateGap.setText(address.getState());
        cityGap.setText(address.getCity());
        cepGap.setText(address.getCep());
        neighborhoodGap.setText(address.getNeighborhood());
        streetGap.setText(address.getStreet());
        numberHomeGap.setText(String.valueOf(address.getNumber()));
        activityLoan.setText(String.valueOf(reader.getLoanLimit()));
        if (reader.getBlock()) {
            accountStatus.setText("BLOQUEADA");
        }
    }
}
