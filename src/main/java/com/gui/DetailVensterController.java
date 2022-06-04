package com.gui;

import com.logic.Huur;
import com.logic.machines.Machine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
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
    public void setCurrentMachine(Machine currentMachine) {
        this.currentMachine = currentMachine;
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
        classLabel.setText(currentMachine.getClassType());
        idLabel.setText("ID: " + currentMachine.getId());
        infoLabel1.setText(currentMachine.getMachineInfo1Type());
        infoField1.setText(currentMachine.getMachineInfo1());
        infoLabel2.setText(currentMachine.getMachineInfo2Type());
        infoField2.setText(currentMachine.getMachineInfo2());
        if (currentMachine.getHuurStatus()){
            verkoperField.setText(currentMachine.getHuur().medewerker().getUsername());
            klantNaamField.setText(currentMachine.getHuur().klantNaam());
            dagenField.setText(currentMachine.getHuur().dagen());
            verzekerBox.setSelected(currentMachine.getHuur().verzekering());
        } else {
            verkoperField.setText(currentMedewerker.getUsername());
        }
    }

    private void setVisibilities(){
        boolean verhuurd = currentMachine.getHuurStatus();
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
        tempHuur = currentMachine.getHuur();
        currentMachine.setProperty(null);
        verkoperField.setText(currentMedewerker.getUsername());
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
            currentMachine.setProperty(new Huur(currentMedewerker, klantnaam, dagen, verzekering));
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
        bedragLabel.setText(String.format("%.2f", currentMachine.getTotaalPrijs(dagen, verzekerd)));
    }

    @FXML
    private void saveActivation(){
        saved = true;
    }

    private boolean fieldsSet(){
        return !klantNaamField.getText().isBlank() && !dagenField.getText().isEmpty();
    }

    @FXML
    public void backActivation(ActionEvent actionEvent) {
        if (!saved){
            currentMachine.setProperty(tempHuur);
        }
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
