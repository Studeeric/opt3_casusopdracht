package com.logic.machines;

import com.Database;

public class VrachtAuto extends Machine{
    private double laadVermogen;
    private double gewicht;

    public VrachtAuto(double laadVermogen, double gewicht){
        this.laadVermogen = laadVermogen;
        this.gewicht = gewicht;
        Database.machineList.add(this);
    }

    public double getLaadVermogen(){
        return this.laadVermogen;
    }

    public double getGewicht(){
        return this.gewicht;
    }

    public String getClassType(){
        return "VrachtAuto";
    }

    public String getMachineInfo(){
        return "Laadvermogen: " + laadVermogen + " | Gewicht: " + gewicht;
    }

    @Override
    public double getHuurPrijs() {
        return 0.10 * laadVermogen;
    }

    @Override
    public double getVerzekeringPrijs() {
        return 0.01 * gewicht;
    }
}
