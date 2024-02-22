package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.dao.DAO;
import org.example.dao.book.BookDAO;
import org.example.exceptions.BookException;
import org.example.model.Book;
import org.example.model.BookLocation;
import org.example.model.Adm;
import org.example.util.AdmHolder;

public class ManageBookController {

    @FXML
    private TextField auhtorField;

    @FXML
    private Button buttonConfirm;

    @FXML
    private TextField categoryField;

    @FXML
    private TextField dispField;

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
    private Label erroMessage;


    @FXML
    void confirmAction(ActionEvent event) {
        Adm adm = AdmHolder.getInstance().getAdm();
        erroMessage.setText("");

        try {
            if(isbnField.getText() == null) {
                erroMessage.setText("Digite um ISBN para editar um Livro!");
            }else{
                erroMessage.setText("");
                BookDAO bookDAO = DAO.getBookDAO();
                String isbnSearch = isbnField.getText();
                if(bookDAO.findByIsbn(isbnSearch) == null){
                    erroMessage.setText("Esse ISBN não existe ou está incorreto.");
                }else{
                    erroMessage.setText("");
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

                    Book book = new Book(isbn, title, author, publishingCompany, yearPublication, category, location, quantity);
                    adm.updateBook(book);

                    AlertMessageController alertMessageController = new AlertMessageController();
                    alertMessageController.setAlert("Edição concluida com sucesso!");}}
        } catch (Exception e) {
            AlertMessageController alertMessageController = new AlertMessageController();
            alertMessageController.setAlert("Não foi possível concluir edição.");
            //throw new RuntimeException(e);
        }}

    @FXML
    void search(ActionEvent event) throws Exception {
        erroMessage.setText("");

        if(isbnField.getText() == null) {
            erroMessage.setText("Digite um ISBN para editar um Livro!");
        }else{
            erroMessage.setText("");
            BookDAO bookDAO = DAO.getBookDAO();
            String isbnSearch = isbnField.getText();
            if(bookDAO.findByIsbn(isbnSearch) == null){
                erroMessage.setText("Esse ISBN não existe ou está incorreto.");}
            else{
                Book book = bookDAO.findByIsbn(isbnSearch);
                erroMessage.setText("");
                isbnField.setText(book.getISBN());
                titleField.setText(book.getTitle());
                auhtorField.setText(book.getAuthor());
                publishField.setText(book.getPublishing_company());
                yearField.setText(Integer.toString(book.getYear_publication()));
                categoryField.setText(book.getCategory());
                shelfField.setText(book.getLocation().getShelf());
                hallField.setText(book.getLocation().getHall());
                sectionField.setText(book.getLocation().getSection());
                totalField.setText(Integer.toString(book.getQuantityTotal()));
                dispField.setText(Integer.toString(book.getQuantityAvailable()));
            }
    }}

}
