package com.logic.machines;

import com.Database;

import java.io.IOException;

public class VrachtAuto extends Machine{
    private double laadVermogen;
    private double gewicht;

    public VrachtAuto() {
    }

    public VrachtAuto(double laadVermogen, double gewicht) throws IOException {
        this.laadVermogen = laadVermogen;
        this.gewicht = gewicht;
        addToDatabase();
    }

    public void setLaadVermogen(double laadVermogen){
        this.laadVermogen = laadVermogen;
    }

    public void setGewicht(double gewicht){
        this.gewicht = gewicht;
    }

    public double getLaadVermogen(){
        return this.laadVermogen;
    }

    public double getGewicht(){
        return this.gewicht;
    }

    public String getMachineInfo1Type(){
        return "Laadvermogen";
    }

    public String getMachineInfo1() {
        return String.format("%.2f",laadVermogen);
    }

    public String getMachineInfo2Type(){
        return "Gewicht";
    }

    public String getMachineInfo2(){
        return String.format("%.2f", gewicht);
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
