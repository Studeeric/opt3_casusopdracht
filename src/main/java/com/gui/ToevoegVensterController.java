package com.gui;

import com.Database;
import com.logic.CurrentSession;
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
import java.util.ResourceBundle;

public class ToevoegVensterController extends Controller implements Initializable {

    @FXML
    private TextField info1Field;

    @FXML
    private TextField info2Field;

    @FXML
    private Button maakButton;


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void setCurrentSession(CurrentSession currentSession){
        this.currentSession = currentSession;
        info1Field.setPromptText(currentSession.getCurrentMachine().getMachineInfo1Type());
        info2Field.setPromptText(currentSession.getCurrentMachine().getMachineInfo2Type());
        if (!currentSession.getCurrentMachine().isInfoType1String()){
            addNumberLimiter(info1Field);
        }
        if (!currentSession.getCurrentMachine().isInfoType2String()){
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
    private void maak(ActionEvent actionEvent) throws IOException {
        currentSession.getCurrentMachine().setInfo2(info2Field.getText());
        currentSession.getCurrentMachine().setInfo1(info1Field.getText());
        currentSession.getCurrentMachine().addToDatabase();
        exit(actionEvent);
    }

    private void exit(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void onTerugClicked(ActionEvent actionEvent) throws IOException {
        Database.removeProperty(currentSession.getCurrentMachine());
        currentSession.setCurrentMachine(null);
        exit(actionEvent);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


}
