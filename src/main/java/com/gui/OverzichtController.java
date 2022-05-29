package com.gui;

import com.Database;
import com.Main;
import com.logic.machines.Machine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
        primairColumn.setCellValueFactory(new PropertyValueFactory<>("classType"));
        productColumn.setCellValueFactory(new PropertyValueFactory<>("machineInfo"));
        beschikbaarColumn.setCellValueFactory(new PropertyValueFactory<>("wordtVerhuurd"));
        ObservableList<Machine> data = FXCollections.observableArrayList(parseUserList());
        detailTable.setItems(data);
    }

    private List<Machine> parseUserList(){
        return Database.machineList;
    }

    @FXML
    private void onMouseClicked() throws IOException {
        if (detailTable.getSelectionModel().getSelectedItem() != null) {
            Main.popUp("DetailVenster", medewerker, true, detailTable.getSelectionModel().getSelectedItem());
        }
    }
}
