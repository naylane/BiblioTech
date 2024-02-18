package org.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.example.model.Librarian;
import org.example.model.Reader;
import org.example.model.Residence;
import org.example.util.LibrarianHolder;
import org.example.util.ReaderHolder;

import java.net.URL;
import java.util.ResourceBundle;

public class LibrarianAccountController implements Initializable {

    @FXML
    private Label accountStatus;

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
    private AnchorPane sceneHomeLibrarian;

    @FXML
    private Label stateGap;

    @FXML
    private Label streetGap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Librarian librarian = LibrarianHolder.getInstance().getLibrarian();
        Residence address = librarian.getAddress();

        nameLabel.setText(librarian.getName());
        idLabel.setText(String.valueOf(librarian.getId()));
        phoneGap.setText(librarian.getPhone());
        stateGap.setText(address.getState());
        cityGap.setText(address.getCity());
        cepGap.setText(address.getCep());
        neighborhoodGap.setText(address.getNeighborhood());
        streetGap.setText(address.getStreet());
        numberHomeGap.setText(String.valueOf(address.getNumber()));

        if (librarian.getBlock()) {
            accountStatus.setText("BLOQUEADA");
        }
    }
}

