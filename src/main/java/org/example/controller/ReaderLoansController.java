package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.example.model.Book;
import org.example.model.Loan;
import org.example.model.Reader;
import org.example.model.Report;
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
    private AnchorPane sceneReaderLoans;

    @FXML
    private TableView<Loan> table;

    ObservableList<Loan> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Reader reader = ReaderHolder.getInstance().getReader();

        id.setCellValueFactory(
                new PropertyValueFactory<>("idLoan"));
        book.setCellValueFactory(
                new PropertyValueFactory<>("book"));
        date.setCellValueFactory(
                new PropertyValueFactory<>("dateLoan"));
        devolution.setCellValueFactory(
                new PropertyValueFactory<>("dateDevolution"));
        renew.setCellValueFactory(
                new PropertyValueFactory<>("renovationQuantity"));
        active.setCellValueFactory(
                new PropertyValueFactory<>("active"));

        Report report = null;
        try {
            report = new Report();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        list.addAll(report.genareteUserLoan(reader));

        table.setItems(list);
    }
}
