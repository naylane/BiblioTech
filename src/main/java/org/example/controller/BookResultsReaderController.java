package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.Main;
import org.example.dao.DAO;
import org.example.model.Book;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookResultsReaderController implements Initializable {
    @FXML
    private Label messageAlert;

    @FXML
    private ImageView buttonBack;

    @FXML
    private Button buttonSearch;

    @FXML
    private VBox vBox;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextField searchBook;
    private String[] position = {"Nome", "Autor", "Categoria", "ISBN"};

    @FXML
    void SearchBook(ActionEvent event) {

        String search = searchBook.getText();

        if (choiceBox.getValue().equals("Autor")) {
            try {
                List<Book> booksFound = DAO.getBookDAO().findByAuthor(search); //livros encontrados com o nome do autor
                display(booksFound);
            } catch (Exception e) {
                messageAlert.setText("Sem Resultados!");
            }
        }else if (choiceBox.getValue().equals("Nome")) {
            try {
                List<Book> booksFound = DAO.getBookDAO().findByTitle(search); //livros encontrados com o nome do autor
                display(booksFound);
            } catch (Exception e) {
                messageAlert.setText("Sem Resultados!");
            }
        }
        else if (choiceBox.getValue().equals("Categoria")) {
            try {
                List<Book> booksFound = DAO.getBookDAO().findByCategory(search); //livros encontrados com o nome do autor
                display(booksFound);
            } catch (Exception e) {
                messageAlert.setText("Sem Resultados!");
            }
        }
        else if (choiceBox.getValue().equals("ISBN")) {
            try {
                Book bookFound = DAO.getBookDAO().findByIsbn(search); //livros encontrados com o nome do autor
                display2(bookFound);
            } catch (Exception e) {
                messageAlert.setText("Sem Resultados!");
            }
        }
    }

    @FXML
    void goBack(MouseEvent event) {
        try {
            //Este trecho obtém o palco atual (tela de login) a partir do evento gerado pelo botão de login
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //fecha a tela home, que é a tela atual
            currentScreen.close();

            //pegando o caminho
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/view/homeReader-view.fxml"));
            Parent login = loader.load(); //carregando o arquivo

            Stage registerStage = new Stage();
            //cria cena
            Scene scene = new Scene(login);

            //não permite que a tela seja redmensionada
            registerStage.setResizable(false);
            //exibição da tela
            registerStage.setScene(scene);
            registerStage.show();
            //define um icone para tela login
            registerStage.getIcons().add(new Image(getClass().getResourceAsStream("/org/example/view/images/symbol.png")));
            registerStage.setTitle("BiblioTech Search"); //nome da pag

        } catch (IOException e) {
            e.printStackTrace();
            //System.err.println("Erro ao carregar o arquivo FXML da tela de login: " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(position);

    }

    public void display(List<Book> books) { //mostrar Lista de Livros
        System.out.println("chega ak");
        vBox.getChildren().clear();
        int numberBooks = books.size();
        int cont=0; //contador

        if(numberBooks==0) {
            //mensagem de erro
            messageAlert.setText("Sem Resultados!");

        }else{
            while(numberBooks>cont) {
                try {
                    System.out.println("chega ak 1");

                    Book book = books.get(cont);

                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/bookField-view.fxml"));

                    AnchorPane novo = fxmlLoader.load();
                    System.out.println("chega ak 3");

                    // Acessa os elementos diretamente usando o método lookup
                    Label nameBookLabel = (Label) novo.lookup("#nameBook");
                    Label availableBook = (Label) novo.lookup("#availableField");

                    // Definindo o texto do Label
                    nameBookLabel.setText(book.getTitle());
                    int numberAvaible = book.getQuantityAvailable();
                    if (numberAvaible > 0) {
                        availableBook.setText("Disponível");
                    } else {
                        availableBook.setText("Indisponível");
                    }

                    vBox.getChildren().add(novo);
                    System.out.println(numberBooks);
                    cont++;
                    messageAlert.setText("");

                } catch (Exception e) {
                    System.out.println("chega ak 2");

                    e.printStackTrace(); //provavelmente vai se referir ao livro, ou carregamento do arquivo
                    cont++;
                }}
        }
    }

    public void display2(Book book) { //mostrar um Livro
        vBox.getChildren().clear();

        if(book==null) {
            //mensagem de erro
            messageAlert.setText("Sem Resultados!");

        }else{
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/bookField-view.fxml"));
                AnchorPane novo = fxmlLoader.load();

                // Acessa os elementos diretamente usando o método lookup
                Label nameBookLabel = (Label) novo.lookup("#nameBook");
                Label availableBook = (Label) novo.lookup("#availableField");

                // Definindo o texto do Label
                nameBookLabel.setText(book.getTitle());
                int numberAvaible = book.getQuantityAvailable();
                if (numberAvaible > 0) {
                    availableBook.setText("Disponível");
                } else {
                    availableBook.setText("Indisponível");
                }

                vBox.getChildren().add(novo);
                messageAlert.setText("");

                } catch (Exception e) {
                    e.printStackTrace(); //provavelmente vai se referir ao livro, ou carregamento do arquivo
                }}
        }
}


