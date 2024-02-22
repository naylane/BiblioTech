package org.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;

public class PrintController {

    @FXML
    private Label book;

    @FXML
    private Label date;

    @FXML
    private Label devolution;

    @FXML
    private Label idLoan;

    public void setData(String idLoan, String book, String date, String dateDevolution) {
        this.idLoan.setText(idLoan);
        this.book.setText(book);
        this.date.setText(date);
        this.devolution.setText(dateDevolution);
    }

    public void show(String idLoan, String book, String date, String dateDevolution) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/view/print-view.fxml"));
        Parent root = loader.load();

        PrintController printController = loader.getController();
        printController.setData(idLoan, book, date, dateDevolution);

        Stage printStage = new Stage();
        Scene scene = new Scene(root);
        printStage.setTitle("Ficha de empréstimo");
        printStage.setResizable(false);
        printStage.setScene(scene);
        printStage.showAndWait();
        printStage.setAlwaysOnTop(true);
    }

}