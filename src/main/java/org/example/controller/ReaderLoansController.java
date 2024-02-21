package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import org.example.model.Book;
import org.example.model.Loan;
import org.example.model.Reader;
import org.example.util.ReaderHolder;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ReaderLoansController implements Initializable {

    @FXML
    private TableColumn<Loan, Boolean> active;

    @FXML
    private TableColumn<Loan, Book> book;

    @FXML
    private TableColumn<Loan, LocalDate> date;

    @FXML
    private TableColumn<Loan, LocalDate> devolution;

    @FXML
    private TableColumn<Loan, Long> id;

    @FXML
    private TableColumn<Loan, Integer> renew;

    @FXML
    private AnchorPane sceneHomeReader;

    @FXML
    private TableView<?> table;

    ObservableList<Loan> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Reader reader = ReaderHolder.getInstance().getReader();
        list.addAll();
    }
}
