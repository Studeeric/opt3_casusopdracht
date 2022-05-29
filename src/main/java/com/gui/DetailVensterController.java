package com.gui;

import com.logic.machines.Machine;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailVensterController extends Controller implements Initializable {

    @FXML
    private Label productLabel;


    public void onHelloButtonClick() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @Override
    public void setCurrentMachine(Machine currentMachine) {
        this.currentMachine = currentMachine;
        productLabel.setText(currentMachine.getMachineInfo());
    }

}
