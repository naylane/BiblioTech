package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.dao.DAO;
import org.example.exceptions.BookException;
import org.example.exceptions.UsersException;
import org.example.model.Book;
import org.example.model.Reader;
import org.example.util.ReaderHolder;

public class ReservationController {

    @FXML
    private Label category;

    @FXML
    private Button buttonRegisterLoan;

    @FXML
    private Label companyL;

    @FXML
    private Label hall;

    @FXML
    private TextField isbnField;

    @FXML
    private Label author;

    @FXML
    private Label qntAval;

    @FXML
    private Label qntTotal;

    @FXML
    private Label messageAlert;

    @FXML
    private Button okButton;

    @FXML
    private AnchorPane sceneReservation;

    @FXML
    private Label section;

    @FXML
    private Label shelf;

    @FXML
    private Label title;

    @FXML
    private Label year;

    @FXML
    void confirmAction(ActionEvent event) throws Exception {
        try {
            Book found = DAO.getBookDAO().findByIsbn(isbnField.getText());
            if (found != null) {
                Reader reader = ReaderHolder.getInstance().getReader();
                reader.makeReservation(reader, found);
            } else {
                messageAlert.setText("Livro não encontrado!");
            }
        } catch (BookException bookException) {
            messageAlert.setText(bookException.getMessage());
        } catch (UsersException usersException) {
            messageAlert.setText(usersException.getMessage());
        }
    }

    @FXML
    void search(ActionEvent event) throws Exception {
        Book found = DAO.getBookDAO().findByIsbn(isbnField.getText());
        if (found != null) {
            title.setText(found.getTitle());
            author.setText(found.getAuthor());
            companyL.setText(found.getPublishing_company());
            year.setText(String.valueOf(found.getYear_publication()));
            category.setText(found.getCategory());
            hall.setText(found.getLocation().getHall());
            section.setText(found.getLocation().getSection());
            shelf.setText(found.getLocation().getShelf());
            qntTotal.setText(String.valueOf(found.getQuantityTotal()));
            qntAval.setText(String.valueOf(found.getQuantityAvailable()));
        } else {
            messageAlert.setText("Livro não encontrado!");
        }
    }

}