package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.dao.DAO;
import org.example.model.Librarian;
import org.example.model.Loan;
import org.example.model.Reader;
import org.example.util.LibrarianHolder;

import java.io.IOException;

public class DevolutionController {

    @FXML
    private Button buttonRegisterDevolution;

    @FXML
    private TextField labelLoan;

    @FXML
    private TextField labelReader;

    @FXML
    void registerDevolution(ActionEvent event) {
        try {
            Librarian librarian = LibrarianHolder.getInstance().getLibrarian();

            Loan loan = DAO.getLoanDAO().findById(Long.parseLong(labelLoan.getText()));
            Reader reader = DAO.getReaderDAO().findById(Long.parseLong(labelReader.getText()));
            if ((loan != null) && (reader != null)) {
                librarian.registerDevolution(loan, reader);
            } else {
                // mostrar mensagem
                //AlertMessageController alertMessageController = new AlertMessageController();
                //alertMessageController.setAlert("Leitor ou empréstimo ativo não encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
