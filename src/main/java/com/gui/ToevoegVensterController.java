package com.gui;

import com.Database;
import com.Main;
import com.logic.CurrentSession;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.beans.PropertyChangeEvent;
import java.io.IOException;

public class ToevoegVensterController extends Controller{

    @FXML
    private TextField info1Field;

    @FXML
    private TextField info2Field;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void setCurrentSession(CurrentSession currentSession){
        this.currentSession = currentSession;
        info1Field.setPromptText(currentSession.getCurrentMachine().getProperty(0).getPROPERTY_TYPE());
        info2Field.setPromptText(currentSession.getCurrentMachine().getProperty(1).getPROPERTY_TYPE());
        if (currentSession.getCurrentMachine().getProperty(0).isNUMERIC()){
            addNumberLimiter(info1Field);
        }
        if (currentSession.getCurrentMachine().getProperty(1).isNUMERIC()){
            addNumberLimiter(info2Field);
        }
    }

    public void addNumberLimiter(TextField textField){
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("\\D", ""));
            }
        });
    }


    @FXML
    private void maak() throws IOException {
        currentSession.getCurrentMachine().getProperty(0).setPropertyValue(info1Field.getText());
        currentSession.getCurrentMachine().getProperty(1).setPropertyValue(info2Field.getText());
        currentSession.getCurrentMachine().addToDatabase();
        exit();
    }

    private void exit() throws IOException {
        currentSession.setFxmlName("Beheer");
        Main.popUp(currentSession);

    }

    @FXML
    private void onTerugClicked() throws IOException {
        Database.removeProperty(currentSession.getCurrentMachine());
        currentSession.setCurrentMachine(null);
        exit();
    }

}
