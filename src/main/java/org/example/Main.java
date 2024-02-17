package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.dao.DAO;
import org.example.dao.FileControl;
import org.example.model.Adm;
import org.example.model.Librarian;
import org.example.model.Reader;
import org.example.model.Residence;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, Exception {
        FileControl.generateData();

        Reader readerCreated = DAO.getReaderDAO().findById(1);
        System.out.println();


        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/bookResults-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("BiblioTech Home");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/org/example/view/images/symbol.png")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
