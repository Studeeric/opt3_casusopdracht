package com.logic;

import com.logic.machines.Machine;

public class CurrentSession {
    private Medewerker currentMedewerker;
    private Machine currentMachine;
    private String fxmlName;

    public void setCurrentMedewerker(Medewerker currentMedewerker){
        this.currentMedewerker = currentMedewerker;
    }

    public void setCurrentMachine(Machine currentMachine){
        this.currentMachine = currentMachine;
    }

    public void setFxmlName(String fxmlName){
        this.fxmlName = fxmlName;
    }

    public Medewerker getCurrentMedewerker(){
        return this.currentMedewerker;
    }

    public Machine getCurrentMachine(){
        return this.currentMachine;
    }

    public String getFxmlName(){
        return this.fxmlName;
    }
}
