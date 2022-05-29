package com.logic.machines;

import com.Database;

public class PersonenAuto extends Machine{
    private String merk;
    private double gewicht;

    public PersonenAuto(String merk, double gewicht){
        this.merk = merk;
        this.gewicht = gewicht;
        Database.machineList.add(this);
    }

    public String getMerk(){
        return this.merk;
    }

    public double getGewicht(){
        return this.gewicht;
    }

    public String getClassType(){
        return "PersonenAuto";
    }

    public String getMachineInfo(){
        return "Merk: " + merk + " | Gewicht: " + gewicht;
    }

    @Override
    public double getHuurPrijs(){
        return 50;
    }
    @Override
    public double getVerzekeringPrijs() {
        return gewicht * 0.01;
    }
}
