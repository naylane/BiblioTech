package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.dao.DAO;
import org.example.exceptions.LoanException;
import org.example.exceptions.UsersException;
import org.example.model.Loan;
import org.example.model.Reader;
import org.example.util.ReaderHolder;

public class RenewController {

    @FXML
    private Label book;

    @FXML
    private Button buttonRegisterLoan;

    @FXML
    private Label date;

    @FXML
    private Label devolution;

    @FXML
    private TextField idField;

    @FXML
    private Label messageAlert;

    @FXML
    private Button okButton;

    @FXML
    private Label qntRenewals;

    @FXML
    private AnchorPane sceneRenew;

    @FXML
    void confirmAction(ActionEvent event) {
        try {
            Loan found = DAO.getLoanDAO().findById(Long.parseLong(idField.getText()));
            if (found != null) {
                Reader reader = ReaderHolder.getInstance().getReader();
                reader.renewLoan(reader, found, found.getBook());
            } else {
                messageAlert.setText("Livro não encontrado!");
            }
        } catch (LoanException loanException) {
            messageAlert.setText(loanException.getMessage());
        } catch (UsersException usersException) {
            messageAlert.setText(usersException.getMessage());
        } catch (Exception e) {
            messageAlert.setText("Ocorreu um erro ao carregar os dados!");
        }
    }

    @FXML
    void search(ActionEvent event) throws Exception {
        Loan found = DAO.getLoanDAO().findById(Long.parseLong(idField.getText()));
        if (found != null) {
            book.setText(found.getBook().getTitle());
            date.setText(String.valueOf(found.getDateLoan()));
            devolution.setText(String.valueOf(found.getDateDevolution()));
            qntRenewals.setText(String.valueOf(found.getRenovationQuantity()));
        } else {
            messageAlert.setText("Empréstimo não encontrado!");
        }
    }

}
