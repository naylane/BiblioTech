package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.dao.DAO;
import org.example.exceptions.UsersException;
import org.example.model.Librarian;
import org.example.model.Reader;
import org.example.model.Adm;
import org.example.util.AdmHolder;
import org.example.util.LibrarianHolder;
import org.example.util.ReaderHolder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField pinField;

    @FXML
    private Button buttonEntrar;

    @FXML
    private Button buttonHome;

    @FXML
    private TextField idField;

    @FXML
    private Label registerPage;

    @FXML
    private Label messageAlert;

    @FXML
    private ChoiceBox<String> choiceBox;

    private String[] position = {"Leitor", "Bibliotecário", "Administrador"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(position);
    }

    @FXML
    public void backHome(ActionEvent event) {
        try {
            //Este trecho obtém o palco atual (tela de login) a partir do evento gerado pelo botão de login
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //fecha a tela home, que é a tela atual
            currentScreen.close();

            //pegando o caminho
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/view/home-view.fxml"));
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
            registerStage.setTitle("BiblioTech Home"); //nome da pag

        } catch (IOException e) {
            e.printStackTrace();
            //System.err.println("Erro ao carregar o arquivo FXML da tela de login: " + e.getMessage());
        }
    }

    @FXML
    public void openSystem(ActionEvent event) throws Exception {
        try {
            if (choiceBox.getValue().equals("Leitor")) {
                loginReader(event);
            } else if (choiceBox.getValue().equals("Bibliotecário")) {
                loginLibrarian(event);
            } else if (choiceBox.getValue().equals("Administrador")) {
                loginAdm(event);
            }
        } catch (NullPointerException e) {
            messageAlert.setText("Por favor, selecione o tipo de conta!");
        }
    }

    public void loginReader(ActionEvent event) {
        try {
            long id = Long.parseLong(idField.getText());
            String pin = pinField.getText();

            Reader found = DAO.getReaderDAO().findById(id);

            if ((found != null) && found.getPin().equals(pin)) {
                if (found.getBlock() == false) {
                    ReaderHolder.getInstance().setReader(found);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/view/homeReader-view.fxml"));
                    openScreen(event, loader);
                } else {
                    messageAlert.setText(UsersException.UserBlock);
                }
            } else {
                messageAlert.setText(UsersException.LoginError);
            }
        } catch (Exception e) {
            messageAlert.setText(UsersException.LoginError);
        }
    }

    public void loginAdm(ActionEvent event) {
        try {
            long id = Long.parseLong(idField.getText());
            String pin = pinField.getText();

            Adm found = DAO.getAdmDAO().findById(id);

            if ((found != null) && found.getPin().equals(pin)) {
                if (found.getBlock() == false) {
                    AdmHolder.getInstance().setAdm(found);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/view/homeAdm-view.fxml"));
                    openScreen(event, loader);
                } else {
                    messageAlert.setText(UsersException.UserBlock);
                }
            } else {
                messageAlert.setText(UsersException.LoginError);
            }
        } catch (Exception e) {
            messageAlert.setText(UsersException.LoginError);
        }
    }

    public void loginLibrarian(ActionEvent event) {
        try {
            long id = Long.parseLong(idField.getText());
            String pin = pinField.getText();

            Librarian found = DAO.getLibrarianDAO().findById(id);

            if ((found != null) && found.getPin().equals(pin)) {
                if (found.getBlock() == false) {
                    LibrarianHolder.getInstance().setLibrarian(found);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/view/homeLibrarian-view.fxml"));
                    openScreen(event, loader);
                } else {
                    messageAlert.setText(UsersException.UserBlock);
                }
            } else {
                messageAlert.setText(UsersException.LoginError);
            }
        } catch (Exception e) {
            messageAlert.setText(UsersException.LoginError);
        }
    }

    public void openScreen(ActionEvent event, FXMLLoader loader){
        try {
            // Este trecho obtém o palco atual (tela de login) a partir do evento rado pelo botão de login
            Stage currentScreen = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // fecha a tela home, que é a tela atual
            currentScreen.close();

            // pegando o caminho
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
            registerStage.setTitle("BiblioTech Home"); //nome da pag

        } catch (IOException e) {
            e.printStackTrace();
            //System.err.println("Erro ao carregar o arquivo FXML da tela de login: " + e.getMessage());
        }
    }

}

