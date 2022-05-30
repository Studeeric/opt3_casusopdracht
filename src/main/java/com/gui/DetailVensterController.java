package com.gui;

import com.logic.machines.Machine;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailVensterController extends Controller implements Initializable {

    @FXML
    private Label classLabel;

    @FXML
    private Pane groenPane;

    @FXML
    private Label idLabel;

    @FXML
    private TextField klantNaamField;

    @FXML
    private Button retourButton;

    @FXML
    private Pane roodPane;

    @FXML
    private TextField verkoperField;


    public void onHelloButtonClick() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @Override
    public void setCurrentMachine(Machine currentMachine) {
        this.currentMachine = currentMachine;
        prepController(currentMachine.getHuurStatus());
    }

    private void prepController(boolean verhuurd){
        classLabel.setText(currentMachine.getClassType());
        idLabel.setText("ID: " + currentMachine.getId());
        roodPane.setVisible(verhuurd);
        groenPane.setVisible(!verhuurd);
        retourButton.setDisable(!verhuurd);
        verkoperField.setDisable(verhuurd);
        klantNaamField.setDisable(verhuurd);
        if (verhuurd){
            verkoperField.setText(currentMachine.getHuur().getMedewerker().getUsername());
            klantNaamField.setText(currentMachine.getHuur().getKlantNaam());
        }
    }

    @FXML
    private void retourActivation(){
        currentMachine.removeHuur();
        verkoperField.setText(currentMedewerker.getUsername());
        klantNaamField.clear();
        setCurrentMachine(currentMachine);
    }

}
