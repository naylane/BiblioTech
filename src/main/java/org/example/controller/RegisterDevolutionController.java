package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.dao.DAO;
import org.example.model.Adm;
import org.example.model.Librarian;
import org.example.model.Loan;
import org.example.model.Reader;
import org.example.util.AdmHolder;
import org.example.util.LibrarianHolder;

public class RegisterDevolutionController {

    @FXML
    private Button buttonRegisterDevolution;

    @FXML
    private TextField labelLoan;

    @FXML
    private TextField labelReader;

    @FXML
    private Label messageAlert;

    @FXML
    private AnchorPane sceneRegisterDevolution;

    @FXML
    void registerDevolution(ActionEvent event) {
        try {
            Librarian librarian = LibrarianHolder.getInstance().getLibrarian();
            Adm adm = AdmHolder.getInstance().getAdm();

            Loan loan = DAO.getLoanDAO().findById(Long.parseLong(labelLoan.getText()));
            Reader reader = DAO.getReaderDAO().findById(Long.parseLong(labelReader.getText()));
            if ((loan != null) && (reader != null)) {
                if (librarian != null) { // se for o bibliotecário logado no sistema
                    librarian.registerDevolution(loan, reader);
                } else if (adm != null) { // se for o bibliotecário logado no sistema
                    adm.registerDevolution(loan, reader); }
            } else {
                messageAlert.setText("Ocorreu um erro.");
            }
        } catch (Exception e) {
            messageAlert.setText("Ocorreu um erro.");
            e.printStackTrace();
        }
    }

}
