package com.gui;

import com.Database;
import com.Main;
import com.logic.CurrentSession;
import com.logic.Medewerker;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController extends Controller {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label welcomeText;

    @FXML
    public void loginButton() throws IOException {
        loginAttempt();
    }

    public void loginAttempt() throws IOException {
        currentSession.setCurrentMedewerker(findMedewerker(usernameField.getText()));
        boolean succes = passwordChecker(passwordField.getText());
        if (succes){
            succesLogin(currentSession.getCurrentMedewerker());
        }
        welcomeText.setVisible(!succes);
        usernameField.clear();
        passwordField.clear();
    }

    public Medewerker findMedewerker(String username){
        for (Medewerker m : Database.getMedewerkerList()){
            if (m.getUsername().equals(username) && !m.isLoggedIn()){
                return m;
            }
        }
        return null;
    }

    public boolean passwordChecker(String password){
        if (currentSession.getCurrentMedewerker() != null){
            return currentSession.getCurrentMedewerker().checkPassword(password);
        }
        return false;
    }

    public void succesLogin(Medewerker medewerker) throws IOException {
        medewerker.setLoggedIn(true);
        currentSession = new CurrentSession();
        Scene scene = new Scene(new AnchorPane(), 480, 640);
        Stage stage = new Stage();
        stage.setScene(scene);
        currentSession.setCurrentStage(stage);
        currentSession.setCurrentMedewerker(medewerker);
        currentSession.setFxmlName("MainMenu");
        Main.popUp(currentSession);
    }
}
