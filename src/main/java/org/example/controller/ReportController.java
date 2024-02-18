package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import org.example.dao.DAO;
import org.example.model.*;
import org.example.util.AdmHolder;

import java.net.URL;
import java.util.ResourceBundle;

public class ReportController implements Initializable {

    @FXML
    public Button okButton;

    @FXML
    private Label labelBorrowedBooks;

    @FXML
    private Label labelLateBooks;

    @FXML
    private TextField idField;

    @FXML
    private Label labelReservedBooks;

    @FXML
    private ListView<Book> popularBookList;

    @FXML
    private ListView<Loan> readerLoanList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Adm adm = AdmHolder.getInstance().getAdm();
            Report report = new Report();

            labelBorrowedBooks.setText(String.valueOf(adm.generateBorrowedBooks(report)));
            labelLateBooks.setText(String.valueOf(adm.generateLateBooks(report)));
            labelReservedBooks.setText(String.valueOf(adm.generateReservedBooks(report)));
            popularBookList.getItems().addAll(adm.genareteHighestPopular(report));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void confirmAction(ActionEvent event) throws Exception {
        Adm adm = AdmHolder.getInstance().getAdm();
        Report report = new Report();

        Reader found = DAO.getReaderDAO().findById(Long.parseLong(idField.getText()));
        if (found != null) {
            readerLoanList.getItems().addAll(adm.genareteUserLoan(found, report));
        }
    }
}
