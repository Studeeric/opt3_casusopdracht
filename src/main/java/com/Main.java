package com;

import com.gui.Controller;
import com.logic.CurrentSession;
import com.logic.Medewerker;
import com.logic.machines.Boormachine;
import com.logic.machines.Machine;
import com.logic.machines.PersonenAuto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    static Stage primaryStage;
    static CurrentSession currentSession = new CurrentSession();

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        popUp(currentSession);
    }

    public static void popUp(CurrentSession cs) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:src/main/resources/com/gui/fxml/" + cs.getFxmlName() + "-view.fxml"));
        AnchorPane mainLayout = loader.load();

        Controller controller = loader.getController();
        controller.setCurrentSession(cs);
        Database.addObserver(controller);
        Database.addObserversToMachines(controller);
        Scene scene = new Scene(mainLayout, 480, 640);
        String c = cs.getFxmlName().substring(0, 1).toUpperCase();
        String title = c + cs.getFxmlName().substring(1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        seed();
        launch();
    }

    private static void seed() {
        new Medewerker("Eric", "Bull");
        new Medewerker("Piet", "Jan");
        Machine m = new Boormachine();
        m.getProperty(0).setPropertyValue("Philips");
        m.getProperty(1).setPropertyValue("Boren");
        m = new PersonenAuto();
        m.getProperty(0).setPropertyValue("Toyota");
        m.getProperty(1).setPropertyValue("250");
        currentSession.setFxmlName("Login");
    }
}