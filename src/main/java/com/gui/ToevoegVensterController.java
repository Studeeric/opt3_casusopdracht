package com.gui;

import com.Database;
import com.logic.CurrentSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;

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
    private void maak(ActionEvent actionEvent) {
        currentSession.getCurrentMachine().getProperty(0).setPropertyValue(info1Field.getText());
        currentSession.getCurrentMachine().getProperty(1).setPropertyValue(info2Field.getText());
        currentSession.getCurrentMachine().addToDatabase();
        exit(actionEvent);
    }

    private void exit(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void onTerugClicked(ActionEvent actionEvent) {
        Database.removeProperty(currentSession.getCurrentMachine());
        currentSession.setCurrentMachine(null);
        exit(actionEvent);
    }

}
