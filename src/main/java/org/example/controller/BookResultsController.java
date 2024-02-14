package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.example.model.Book;

public class BookResultsController {

    @FXML
    private ImageView buttonBack;

    @FXML
    private ListView<Book> listResult;

    @FXML
    void goBack(MouseEvent event) {
        // tem que saber qual tela estava anteriormente
    }

}

