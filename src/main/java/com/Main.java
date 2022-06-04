package com;

import com.gui.Controller;
import com.logic.Huur;
import com.logic.Medewerker;
import com.logic.machines.Boormachine;
import com.logic.machines.Machine;
import com.logic.machines.PersonenAuto;
import com.logic.machines.VrachtAuto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        popUp("login", null, null);
    }

    public static void popUp(String fxml, Medewerker medewerker, Machine machine) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:src/main/resources/com/gui/fxml/" + fxml + "-view.fxml"));
        AnchorPane mainLayout = loader.load();

        Controller controller = loader.getController();
        controller.setCurrentMedewerker(medewerker);
        controller.setCurrentMachine(machine);
        Database.addObserver(controller);
        Database.addObserversToMachines(controller);
        Scene scene = new Scene(mainLayout, 480, 640);
        String c = fxml.substring(0, 1).toUpperCase();
        String title = c + fxml.substring(1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        seed();
        launch();
    }

    private static void seed() throws IOException {
        new Medewerker("Broeder", "Bier");
        Medewerker medewerker = new Medewerker("Eric", "Bull");
        new Boormachine("Boormachine merk", "Boren?").setProperty(new Huur(medewerker, "Stef Beens", "7", false));
        new PersonenAuto("Auto merk", 69);
        new VrachtAuto(420, 666);
        new Boormachine("Boormachine merk 2!!", "Grillen");
    }
}