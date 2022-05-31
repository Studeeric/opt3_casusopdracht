package com.gui;

import com.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.util.Observable;

public class MainMenuController extends Controller{

    @FXML
    private Button exitButton;

    @FXML
    private Label actieveMedewerker;

    public void onHelloButtonClick() {
        actieveMedewerker.setText(currentMedewerker.getUsername());
    }

    public void onExitButtonClick(){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void onOverzichtButtonClick() throws IOException {
        Main.popUp("overzicht", currentMedewerker, currentMachine);
    }

    public void onBeheerButtonClick() throws IOException {
        Main.popUp("beheer", currentMedewerker, currentMachine);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
