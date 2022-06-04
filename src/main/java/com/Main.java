package com;

import com.gui.Controller;
import com.logic.CurrentSession;
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
        if (cs.getCurrentMedewerker() == null){
            System.out.println("Onderweg naar : " + cs.getFxmlName() + "is medewerker verdwenen.");
        }
        if (cs.getCurrentMachine() == null){
            System.out.println("Onderweg naar : " + cs.getFxmlName() + "is machine verdwenen.");
        }
        Scene scene = new Scene(mainLayout, 480, 640);
        String c = cs.getFxmlName().substring(0, 1).toUpperCase();
        String title = c + cs.getFxmlName().substring(1);
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
        new Medewerker("Eric", "Bull");
        new Boormachine("Test", "Test2");
        currentSession.setFxmlName("Login");
    }
}