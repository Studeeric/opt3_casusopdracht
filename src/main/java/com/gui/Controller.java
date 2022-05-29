package com.gui;

import com.logic.Medewerker;
import com.logic.machines.Machine;

public abstract class Controller {
    protected Medewerker medewerker;
    protected Machine currentMachine;

    public void setMedewerker(Medewerker medewerker){
        this.medewerker = medewerker;
    }

    public void setCurrentMachine(Machine currentMachine) {
        this.currentMachine = currentMachine;
    }
}
