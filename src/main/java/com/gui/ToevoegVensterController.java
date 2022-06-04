package com.gui;

import com.Database;
import com.logic.machines.Boormachine;
import com.logic.machines.Machine;
import com.logic.machines.PersonenAuto;
import com.logic.machines.VrachtAuto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class ToevoegVensterController extends Controller implements Initializable {


    @FXML
    private TextField gewichtField;

    @FXML
    private TextField laadvermogenField;

    @FXML
    private Button maakButton;

    @FXML
    private TextField merkField;

    @FXML
    private TextField typeField;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void setCurrentMachine(Machine currentMachine){
        this.currentMachine = currentMachine;
        if (currentMachine instanceof PersonenAuto){
            merkField.setVisible(true);
            gewichtField.setVisible(true);
        } else if (currentMachine instanceof VrachtAuto) {
            laadvermogenField.setVisible(true);
            gewichtField.setVisible(true);
        } else if (currentMachine instanceof Boormachine) {
            merkField.setVisible(true);
            typeField.setVisible(true);
        }
    }


    @FXML
    private void maak(ActionEvent actionEvent) throws IOException {
        if (currentMachine instanceof PersonenAuto auto){
            auto.setMerk(merkField.getText());
            auto.setGewicht(Integer.parseInt(gewichtField.getText()));
        } else if (currentMachine instanceof VrachtAuto vrauto) {
            vrauto.setLaadVermogen(Integer.parseInt(laadvermogenField.getText()));
            vrauto.setGewicht(Integer.parseInt(gewichtField.getText()));
        } else if (currentMachine instanceof Boormachine boor) {
            boor.setMerk(merkField.getText());
            boor.setType(typeField.getText());
        }
        currentMachine.addToDatabase();
        exit(actionEvent);
    }

    private void exit(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void onTerugClicked(ActionEvent actionEvent) throws IOException {
        Database.removeProperty(currentMachine);
        currentMachine = null;
        exit(actionEvent);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addNumberLimiter();
    }

    public void addNumberLimiter(){
        gewichtField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                gewichtField.setText(newValue.replaceAll("\\D", ""));
            }
        });
        laadvermogenField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                laadvermogenField.setText(newValue.replaceAll("\\D", ""));
            }
        });
    }
}
