package com.gui;

import com.Database;
import com.Main;
import com.logic.Medewerker;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.beans.PropertyChangeEvent;
import java.io.IOException;

public class LoginController extends Controller {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label welcomeText;

    public void onHelloButtonClick() throws IOException {
        boolean notFound = true;
        for (Medewerker medewerker : Database.getMedewerkerList()){
            if (medewerker.getUsername().equals(usernameField.getText())){
                if (medewerker.checkPassword(passwordField.getText())){
                    notFound = false;
                    currentSession.setCurrentMedewerker(medewerker);
                    currentSession.setFxmlName("MainMenu");
                    Main.popUp(currentSession);
                }
            }
        }
        welcomeText.setVisible(notFound);
        usernameField.clear();
        passwordField.clear();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
