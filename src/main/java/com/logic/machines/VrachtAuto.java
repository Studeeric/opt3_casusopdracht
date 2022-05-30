package com.logic.machines;

import com.Database;

public class VrachtAuto extends Machine{
    private final double laadVermogen;
    private final double gewicht;

    public VrachtAuto(double laadVermogen, double gewicht){
        this.laadVermogen = laadVermogen;
        this.gewicht = gewicht;
        Database.addMachine(this);
    }

    public double getLaadVermogen(){
        return this.laadVermogen;
    }

    public double getGewicht(){
        return this.gewicht;
    }

    @Override
    public String getClassType(){
        return "VrachtAuto";
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
