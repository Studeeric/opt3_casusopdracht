package com.logic.machines;

import com.Database;

public class PersonenAuto extends Machine{
    private final String merk;
    private final double gewicht;

    public PersonenAuto(String merk, double gewicht){
        this.merk = merk;
        this.gewicht = gewicht;
        Database.addMachine(this);
    }

    public String getMerk(){
        return this.merk;
    }

    public double getGewicht(){
        return this.gewicht;
    }

    public String getMachineInfo1Type(){
        return "Merk";
    }

    public String getMachineInfo1() {
        return merk;
    }

    public String getMachineInfo2Type(){
        return "Gewicht";
    }

    public String getMachineInfo2(){
        return String.format("%.2f", gewicht);
    }

    @Override
    public String getClassType(){
        return "PersonenAuto";
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
