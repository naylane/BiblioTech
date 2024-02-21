package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.dao.DAO;
import org.example.model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class AllUsersController implements Initializable {

    @FXML
    private TableColumn<User, Long> id;

    @FXML
    private TableColumn<User, String> name;

    @FXML
    private TableColumn<String, String> position;

    @FXML
    private TableView<User> table;

    private ObservableList<User> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        name.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        position.setCellValueFactory(
                new PropertyValueFactory<>("position"));

        try {
            list.addAll(DAO.getAdmDAO().findAll());
            list.addAll(DAO.getLibrarianDAO().findAll());
            list.addAll(DAO.getReaderDAO().findAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        table.setItems(list);
    }

}