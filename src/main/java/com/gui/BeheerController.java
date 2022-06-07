package com.gui;

import com.Main;
import com.logic.factories.AbstractFactory;
import com.logic.factories.FactoryProvider;
import com.logic.machines.Machine;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

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

    @SuppressWarnings("rawtypes")
    private AbstractFactory factory;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @FXML
    private void onTerugClicked() throws IOException {
        currentSession.setFxmlName("MainMenu");
        Main.popUp(currentSession);
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
        objectBox.setDisable(false);
        addMachines();
    }

    @FXML
    public void selectMachine(){
        createButton.setDisable(objectBox.getValue().isEmpty());
    }

    @FXML
    public void create() throws IOException {
        Machine machine = (Machine) factory.create(objectBox.getValue());
        currentSession.setCurrentMachine(machine);
        currentSession.setFxmlName("ToevoegVenster");
        Main.popUp(currentSession);
    }
}
