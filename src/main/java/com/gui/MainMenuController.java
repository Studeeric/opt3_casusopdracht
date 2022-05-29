package com.gui;

import com.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController extends Controller{

    @FXML
    private Button exitButton;

    @FXML
    private Label actieveMedewerker;

    public void onHelloButtonClick() {
        actieveMedewerker.setText(medewerker.getUsername());
    }

    public void onExitButtonClick(){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void onOverzichtButtonClick() throws IOException {
        Main.popUp("overzicht", medewerker, false);
    }

    public void onBeheerButtonClick() throws IOException {
        Main.popUp("beheer", medewerker, false);
    }
}
