package com.gui;

import com.Main;
import com.logic.CurrentSession;
import com.logic.Huur;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DetailVensterController extends Controller implements Initializable {


    @FXML
    private Label bedragLabel;

    @FXML
    private Label classLabel;

    @FXML
    private TextField dagenField;

    @FXML
    private Pane groenPane;

    @FXML
    private Label idLabel;

    @FXML
    private TextField infoField1;

    @FXML
    private TextField infoField2;

    @FXML
    private Text infoLabel1;

    @FXML
    private Text infoLabel2;

    @FXML
    private TextField klantNaamField;

    @FXML
    private Button retourButton;

    @FXML
    private Pane roodPane;

    @FXML
    private TextField verkoperField;

    @FXML
    private CheckBox verzekerBox;

    private Huur tempHuur;
    private boolean saved = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @Override
    public void setCurrentSession(CurrentSession currentSession) {
        this.currentSession = currentSession;
        prepController();
    }

    private void prepController(){
        setInfo();
        setVisibilities();
        showPrice();
    }

    public void addNumberLimiter(){
        dagenField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                dagenField.setText(newValue.replaceAll("\\D", ""));
            }
        });
    }

    private void setInfo(){
        classLabel.setText(currentSession.getCurrentMachine().getClassType());
        idLabel.setText("ID: " + currentSession.getCurrentMachine().getId());
        infoLabel1.setText(currentSession.getCurrentMachine().getProperty(0).getPROPERTY_TYPE());
        infoField1.setText(currentSession.getCurrentMachine().getProperty(0).getPropertyValue());
        infoLabel2.setText(currentSession.getCurrentMachine().getProperty(1).getPROPERTY_TYPE());
        infoField2.setText(currentSession.getCurrentMachine().getProperty(1).getPropertyValue());
        if (currentSession.getCurrentMachine().getHuurStatus()){
            verkoperField.setText(currentSession.getCurrentMachine().getHuur().medewerker().getUsername());
            klantNaamField.setText(currentSession.getCurrentMachine().getHuur().klantNaam());
            dagenField.setText(currentSession.getCurrentMachine().getHuur().dagen());
            verzekerBox.setSelected(currentSession.getCurrentMachine().getHuur().verzekering());
        } else {
            verkoperField.setText(currentSession.getCurrentMedewerker().getUsername());
        }
    }

    private void setVisibilities(){
        boolean verhuurd = currentSession.getCurrentMachine().getHuurStatus();
        roodPane.setVisible(verhuurd);
        groenPane.setVisible(!verhuurd);
        retourButton.setDisable(!verhuurd);
        klantNaamField.setDisable(verhuurd);
        dagenField.setDisable(verhuurd);
        verzekerBox.setDisable(verhuurd);
        addNumberLimiter();
        addTextLimiter();
    }

    public void addTextLimiter() {
        int maxLength = 9;
        dagenField.textProperty().addListener((ov, oldValue, newValue) -> {
            if (dagenField.getText().length() > maxLength) {
                String s = dagenField.getText().substring(0, maxLength);
                dagenField.setText(s);
            }
        });
    }

    @FXML
    private void retourActivation(){
        tempHuur = currentSession.getCurrentMachine().getHuur();
        currentSession.getCurrentMachine().setHuur(null);
        verkoperField.setText(currentSession.getCurrentMedewerker().getUsername());
        klantNaamField.clear();
        dagenField.clear();
        verzekerBox.setSelected(false);
        prepController();
        saved = false;
    }

    @FXML
    private void isChecked(){
        if (!dagenField.getText().isEmpty()){
            showPrice();
        }
        saved = false;
    }

    @FXML
    private void onVerhuurClicked(){
        if (fieldsSet()){
            String klantnaam = klantNaamField.getText();
            String dagen = dagenField.getText();
            boolean verzekering = verzekerBox.isSelected();
            currentSession.getCurrentMachine().setHuur(new Huur(currentSession.getCurrentMedewerker(), klantnaam, dagen, verzekering));
        }
        saved = false;
        prepController();
    }

    @FXML
    private void keyTyped(){
        if (!dagenField.getText().isEmpty()){
            showPrice();
        }
        saved = false;
    }

    private void showPrice(){
        int dagen;
        try {
            dagen = Integer.parseInt(dagenField.getText());
        } catch (NumberFormatException e){
            dagen = 0;
        }
        boolean verzekerd = verzekerBox.isSelected();
        bedragLabel.setText(String.format("%.2f", currentSession.getCurrentMachine().getTotaalPrijs(dagen, verzekerd)));
    }

    @FXML
    private void saveActivation(){
        saved = true;
    }

    private boolean fieldsSet(){
        return !klantNaamField.getText().isBlank() && !dagenField.getText().isEmpty();
    }

    @FXML
    public void backActivation() throws IOException {
        if (!saved){
            currentSession.getCurrentMachine().setHuur(tempHuur);
        }
        currentSession.setFxmlName("Overzicht");
        Main.popUp(currentSession);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        setInfo();
    }
}
