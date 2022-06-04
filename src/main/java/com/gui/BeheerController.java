package com.gui;

import com.Main;
import com.logic.factories.AbstractFactory;
import com.logic.factories.FactoryProvider;
import com.logic.machines.Machine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BeheerController extends Controller implements Initializable {

    @FXML
    private ComboBox<String> objectBox;

    @FXML
    private ComboBox<String> factoryBox;

    @FXML
    private Button createButton;

    private AbstractFactory factory;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @FXML
    private void onTerugClicked(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addFactories();
    }

    public void addFactories(){
        factoryBox.getItems().add("Machines");
    }

    public void addMachines(){
        objectBox.getItems().clear();
        objectBox.getItems().add("Boormachine");
        objectBox.getItems().add("Personenauto");
        objectBox.getItems().add("Vrachtauto");
    }

    @FXML
    public void selectFactory(){
        factory = FactoryProvider.getFactory(factoryBox.getValue());
        System.out.println(factoryBox.getValue());
        objectBox.setDisable(false);
        addMachines();
    }

    @FXML
    public void selectMachine(){
        createButton.setDisable(objectBox.getValue().isEmpty());
    }

    @FXML
    public void create() throws IOException {
        currentMachine = (Machine) factory.create(objectBox.getValue());
        Main.popUp("ToevoegVenster", currentMedewerker, currentMachine);
    }
}
