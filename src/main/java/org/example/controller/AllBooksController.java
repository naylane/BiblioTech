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

import java.net.URL;
import java.util.ResourceBundle;

public class AllBooksController implements Initializable {

    @FXML
    private TableColumn<Book, String> isbn;

    @FXML
    private TableColumn<Book, Integer> qnt;

    @FXML
    private TableView<Book> table;

    @FXML
    private TableColumn<Book, String> title;

    //private ObservableList<Book> list;

    private ObservableList<Book> list() {
        try {
            for (Book book : DAO.getBookDAO().findAll()) {
                list().add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        isbn.setCellValueFactory(
                new PropertyValueFactory<>("isbn"));
        title.setCellValueFactory(
                new PropertyValueFactory<>("title"));
        qnt.setCellValueFactory(
                new PropertyValueFactory<>("quantityTotal"));

        table.setItems(list());
    }
}
