package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.dao.DAO;
import org.example.dao.FileControl;
import org.example.dao.book.BookDAO;
import org.example.model.*;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, Exception {
        FileControl.generateData();

//        System.out.println(DAO.getAdmDAO().findAll());
//        System.out.println(DAO.getLibrarianDAO().findAll());
//        System.out.println(DAO.getReaderDAO().findAll());

//        //os livros abaixo ja foram criados
//        BookLocation location = new BookLocation("A", "B", "22");
//        BookLocation location1 = new BookLocation("C", "C", "17");
//        Book book = new Book("00000", "Turma da Monica", "Mauricio de Sousa", "MSP", 1990, "animado", location, 1);
//        Book book2 = new Book("11111", "Sara a Princesa", "Sara Souza", "MSP", 2000, "Terror", location1, 2);
//        Book book3 = new Book("22222", "Cronicas 1", "Sara Maria Lima", "XSC", 2010, "Romance", location, 1);
//        Book book4 = new Book("33333", "Cronicas 2", "Sara Maria Lima", "XSC", 2022, "Romance", location1, 1);
//
//        BookDAO bookDAO = DAO.getBookDAO();
//        bookDAO.create(book);
//        bookDAO.create(book4);
//        bookDAO.create(book3);
//        bookDAO.create(book2);
//
//        //criando contas admin - ja criadas
//        Residence residence = new Residence("bahia", "Feira de Santana", "Brasilia", "rua 2", 45, "44004-444");
//        Adm adm = new Adm("admin", "123", "(75) 9 9999-9999", residence, "Adm");
//        Reader reader = new Reader("admin", "123", "(75) 9 9999-9999", residence, "Reader");
//        Librarian librarian = new Adm("admin", "123", "(75) 9 9999-9999", residence, "Librarian");
//        DAO.getAdmDAO().create(adm);
//        DAO.getReaderDAO().create(reader);
//        DAO.getLibrarianDAO().create(librarian);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/home-view.fxml"));
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
