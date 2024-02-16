package org.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ReportController {

    @FXML
    private ImageView goBack;

    @FXML
    private Label labelBorrowedBooks;

    @FXML
    private Label labelLateBooks;

    @FXML
    private TextField labelReaderID;

    @FXML
    private Label labelReservedBooks;

    @FXML
    private ListView<?> popularBookList;

    @FXML
    private ListView<?> readerLoanList;

}
