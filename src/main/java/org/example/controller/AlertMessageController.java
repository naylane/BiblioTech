package org.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.exceptions.UsersException;
import org.example.model.User;

import java.io.IOException;

public class AlertMessageController {

    @FXML
    private Text alert;

    public void setAlert(String warning) {
        this.alert.setText(warning);
    }

    public void showAlertMensage(String mensage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/view/alertMensage-view.fxml"));
        Parent root = loader.load();
        AlertMessageController alertMessageController = loader.getController();
        alertMessageController.setAlert(mensage);
        Stage alertStage = new Stage();
        Scene scene = new Scene(root);
        alertStage.setResizable(false);
        alertStage.setScene(scene);
        alertStage.showAndWait();
        alertStage.setAlwaysOnTop(true);

        alertStage.getIcons().add(new Image(getClass().getResourceAsStream("/org/example/view/images/symbol.png")));
    }

}
