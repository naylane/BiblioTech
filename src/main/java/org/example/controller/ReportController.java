package org.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ReportController {

    @FXML
    private ImageView goBack;

    @FXML
    private Label labelBorrowedBooks;

    @FXML
    private Label labelLateBooks;

    @FXML
    private TextField labelReaderID;

    @FXML
    private Label labelReservedBooks;

    @FXML
    private ListView<?> popularBookList;

    @FXML
    private ListView<?> readerLoanList;

    @FXML
    void toHomeAdm(MouseEvent event) throws IOException {
        // fecha a tela atual
        Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentScreen.close();
        // carrega nova tela
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/view/homeAdm-view.fxml"));
        Parent login = loader.load();
        Scene scene = new Scene(login);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/org/example/view/images/symbol.png")));
        stage.setTitle("BiblioTech Infos");
        stage.show();
    }

}
