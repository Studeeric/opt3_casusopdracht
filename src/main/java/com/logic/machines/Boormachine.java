package com.logic.machines;

import com.Database;

import java.io.IOException;

public class Boormachine extends Machine{
    private String merk;
    private String type;

    public Boormachine() {
    }

    public Boormachine(String merk, String type) throws IOException {
        this.merk = merk;
        this.type = type;
        addToDatabase();
    }

    public void setMerk(String merk){
        this.merk = merk;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getMerk() {
        return merk;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getClassType(){
        return "Boormachine";
    }

    public String getMachineInfo1Type(){
        return "Merk";
    }

    public String getMachineInfo1() {
        return merk;
    }

    public String getMachineInfo2Type(){
        return "Type";
    }

    public String getMachineInfo2(){
        return type;
    }

    @Override
    public double getHuurPrijs() {
        return 5;
    }

    @Override
    public double getVerzekeringPrijs() {
        return 1;
    }
}
