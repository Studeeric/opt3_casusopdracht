package com.gui;

import com.logic.Medewerker;
import com.logic.machines.Machine;

public abstract class Controller {
    protected Medewerker currentMedewerker;
    protected Machine currentMachine;

    public void setCurrentMedewerker(Medewerker currentMedewerker){
        this.currentMedewerker = currentMedewerker;
    }

    public void setCurrentMachine(Machine currentMachine) {
        this.currentMachine = currentMachine;
    }
}
