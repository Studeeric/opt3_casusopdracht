package com.logic.machines;

import com.Database;

import java.io.IOException;

public class PersonenAuto extends Machine{
    private String merk;
    private double gewicht;

    public PersonenAuto() {
    }

    public PersonenAuto(String merk, double gewicht) throws IOException {
        this.merk = merk;
        this.gewicht = gewicht;
        addToDatabase();
    }

    public void setMerk(String merk){
        this.merk = merk;
    }

    public void setGewicht(double gewicht){
        this.gewicht = gewicht;
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
