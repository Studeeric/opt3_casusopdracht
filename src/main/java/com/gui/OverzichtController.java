package com.gui;

import com.Database;
import com.Main;
import com.logic.machines.Machine;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class OverzichtController extends Controller implements Initializable {

    @FXML
    private TableView<Machine> detailTable;

    @FXML
    private TableColumn<Machine, Machine> primairColumn;

    @FXML
    private TableColumn<Machine, String> productColumn;

    @FXML
    private TableColumn<Machine, Boolean> beschikbaarColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUp();
    }

    private void setUp(){
        primairColumn.setCellValueFactory(new PropertyValueFactory<>("classType"));
        productColumn.setCellValueFactory(new PropertyValueFactory<>("machineInfo"));
        beschikbaarColumn.setCellValueFactory(new PropertyValueFactory<>("HuurStatusString"));
        ObservableList<Machine> data = FXCollections.observableArrayList(parseUserList());
        detailTable.setItems(data);
    }

    private List<Machine> parseUserList(){
        return Database.getMachineList();
    }

    @FXML
    private void onMouseClicked() throws IOException {
        if (detailTable.getSelectionModel().getSelectedItem() != null) {
            Main.popUp("DetailVenster", currentMedewerker, detailTable.getSelectionModel().getSelectedItem());
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        setUp();
        detailTable.refresh();
    }
}
