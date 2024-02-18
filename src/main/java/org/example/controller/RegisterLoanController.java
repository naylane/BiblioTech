package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.dao.DAO;
import org.example.exceptions.LoanException;
import org.example.model.Book;
import org.example.model.Librarian;
import org.example.model.Reader;
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

            String isbn = isbnField.getText();
            Book bookFound = DAO.getBookDAO().findByIsbn(isbn);

            long id = Long.parseLong(idField.getText());
            Reader readerFound = DAO.getReaderDAO().findById(id);

            if (bookFound != null) {
                if (readerFound != null) {
                    librarian.creatLoan(readerFound, bookFound);
                    System.out.println("criou");
                } else {
                    System.out.println("leitor");
                    messageAlert.setText("Leitor não encontrado!");
                    AlertMessageController alertMessageController = new AlertMessageController();
                    alertMessageController.showAlertMensage("Leitor não encontrado!");
                }
            } else {
                System.out.println("livro");
                messageAlert.setText("Livro não encontrado!");
                AlertMessageController alertMessageController = new AlertMessageController();
                alertMessageController.showAlertMensage("Livro não encontrado!");
            }
        } catch (Exception e) {
            messageAlert.setText("Ocorreu um erro! Verifique os dados e tente novamente.");

        }
    }

}
