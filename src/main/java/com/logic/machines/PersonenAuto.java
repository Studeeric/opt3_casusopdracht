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

    @Override
    public void setInfo1(String info1) {
        this.merk = info1;
    }

    @Override
    public void setInfo2(String info2) {
        this.gewicht = Double.parseDouble(info2);
    }
    @Override
    public String getMachineInfo1Type(){
        return "Merk";
    }

    @Override
    public String getMachineInfo1() {
        return merk;
    }

    @Override
    public String getMachineInfo2Type(){
        return "Gewicht";
    }

    @Override
    public boolean isInfoType1String() {
        return true;
    }

    @Override
    public boolean isInfoType2String() {
        return false;
    }

    @Override
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
