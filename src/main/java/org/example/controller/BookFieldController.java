package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class BookFieldController {

    @FXML
    private AnchorPane anchorPaneBook;

    @FXML
    private Label availableField;
    @FXML
    private Label nameBook;

    @FXML
    void anchorPaneBookAction(MouseEvent event) {

    }

    public Label getAvailableField() {
        return availableField;
    }

    public Label getNameBook() {
        return nameBook;
    }

    public void setAvailableField(Label availableField) {
        this.availableField = availableField;
    }

    public void setNameBook(Label nameBook) {
        this.nameBook = nameBook;
    }

}
