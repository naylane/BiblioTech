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
import org.example.model.*;
import org.example.util.AdmHolder;
import org.example.util.LibrarianHolder;

public class RegisterLoanController {

    @FXML
    private Button buttonRegisterLoan;

    @FXML
    private TextField idField;

    @FXML
    private TextField isbnField;

    @FXML
    private Label messageAlert;

    @FXML
    private AnchorPane sceneRegisterLoan;

    @FXML
    void confirmAction(ActionEvent event) throws Exception {
        try {
            Librarian librarian = LibrarianHolder.getInstance().getLibrarian();
            Adm adm = AdmHolder.getInstance().getAdm();

            String isbn = isbnField.getText();
            Book bookFound = DAO.getBookDAO().findByIsbn(isbn);

            long id = Long.parseLong(idField.getText());
            Reader readerFound = DAO.getReaderDAO().findById(id);

            if (bookFound != null) {
                if (readerFound != null) {
                    if (librarian != null) { // se for o bibliotecário logado no sistema
                        Loan loan = librarian.creatLoan(readerFound, bookFound);

                        String idLoan = String.valueOf(loan.getIdLoan());
                        String book = String.valueOf(loan.getBook());
                        String date = String.valueOf(loan.getDateLoan());
                        String devolution = String.valueOf(loan.getDateDevolution());

                        PrintController printController = new PrintController();
                        printController.show(idLoan, book, date, devolution);
                    } else if (adm != null) { // se for o bibliotecário logado no sistema
                        Loan loan = adm.creatLoan(readerFound, bookFound);

                        String idLoan = String.valueOf(loan.getIdLoan());
                        String book = String.valueOf(loan.getBook().getTitle());
                        String date = String.valueOf(loan.getDateLoan());
                        String devolution = String.valueOf(loan.getDateDevolution());

                        PrintController printController = new PrintController();
                        printController.show(idLoan, book, date, devolution);
                    }
                } else {
                    messageAlert.setText(UsersException.UserNotFound); }
            } else {
                messageAlert.setText(BookException.BookNotFound); }
        } catch (Exception e) {
            e.printStackTrace();
            messageAlert.setText("Ocorreu um erro! Verifique os dados e tente novamente.");
        }
    }

}
