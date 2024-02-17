package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.model.BookLocation;
import org.example.model.Librarian;
import org.example.util.LibrarianHolder;

public class RegisterBookController {

    @FXML
    private TextField auhtorField;

    @FXML
    private Button buttonConfirm;

    @FXML
    private TextField categoryField;

    @FXML
    private TextField hallField;

    @FXML
    private TextField isbnField;

    @FXML
    private TextField publishField;

    @FXML
    private AnchorPane sceneManageBook;

    @FXML
    private TextField sectionField;

    @FXML
    private TextField shelfField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField totalField;

    @FXML
    private TextField yearField;

    @FXML
    void confirmAction(ActionEvent event) {
        try {
            Librarian librarian = LibrarianHolder.getInstance().getLibrarian();

            String isbn = isbnField.getText();
            String title = titleField.getText();
            String author = auhtorField.getText();
            String publishingCompany = publishField.getText();
            int yearPublication = Integer.parseInt(yearField.getText());
            String category = categoryField.getText();
            String shelf = shelfField.getText();
            String hall = hallField.getText();
            String section = sectionField.getText();
            BookLocation location = new BookLocation(shelf, hall, section);
            int quantity = Integer.parseInt(totalField.getText());

            librarian.registerBook(isbn, title, author, publishingCompany, yearPublication, category, location, quantity);

            AlertMessageController alertMessageController = new AlertMessageController();
            alertMessageController.setAlert("Cadastro concluido com sucesso!");
        } catch (Exception e) {
            AlertMessageController alertMessageController = new AlertMessageController();
            alertMessageController.setAlert("Não foi possível concluir cadastro.");
            //throw new RuntimeException(e);
        }
    }

}
