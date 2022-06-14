package com.gui;

import com.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.io.IOException;

public class MainMenuController extends Controller{

    @FXML
    private Button exitButton;

    public void onExitButtonClick(){
        currentSession.getCurrentMedewerker().setLoggedIn(false);
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void onOverzichtButtonClick() throws IOException {
        currentSession.setFxmlName("Overzicht");
        Main.popUp(currentSession);
    }

    public void onBeheerButtonClick() throws IOException {
        currentSession.setFxmlName("Beheer");
        Main.popUp(currentSession);
    }

}
