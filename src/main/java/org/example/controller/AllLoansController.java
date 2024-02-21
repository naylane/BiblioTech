package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.dao.DAO;
import org.example.model.Book;
import org.example.model.Loan;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AllLoansController implements Initializable {

    @FXML
    private TableColumn<Loan, Boolean> active;

    @FXML
    private TableColumn<Loan, Book> book;

    @FXML
    private TableColumn<Loan, LocalDate> date;

    @FXML
    private TableColumn<Loan, Long> id;

    @FXML
    private TableColumn<?, ?> reader;

    @FXML
    private TableColumn<?, ?> renew;

    @FXML
    private TableView<Loan> table;

    private ObservableList<Loan> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Adm adm = AdmHolder.getInstance().getAdm();
        try {
            list.addAll(DAO.getLoanDAO().findAll());
            id.setCellValueFactory(
                    new PropertyValueFactory<>("id")
            );
            reader.setCellValueFactory(
                new PropertyValueFactory<>("reader")
            );

            table.setItems(list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
