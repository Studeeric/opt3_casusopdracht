package com.logic.machines;

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

    @Override
    public void setInfo1(String info1) {
        this.laadVermogen = Double.parseDouble(info1);
    }

    @Override
    public void setInfo2(String info2) {
        this.gewicht = Double.parseDouble(info2);
    }

    @Override
    public String getMachineInfo1Type(){
        return "Laadvermogen";
    }

    @Override
    public String getMachineInfo1() {
        return String.format("%.2f",laadVermogen);
    }

    @Override
    public String getMachineInfo2Type(){
        return "Gewicht";
    }

    @Override
    public boolean isInfoType1String() {
        return false;
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
