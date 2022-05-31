package com.gui;

import com.logic.Medewerker;
import com.logic.machines.Machine;

import java.beans.PropertyChangeListener;

public abstract class Controller implements PropertyChangeListener {
    protected Medewerker currentMedewerker;
    protected Machine currentMachine;

    public void setCurrentMedewerker(Medewerker currentMedewerker){
        this.currentMedewerker = currentMedewerker;
    }

    public void setCurrentMachine(Machine currentMachine) {
        this.currentMachine = currentMachine;
    }
}
