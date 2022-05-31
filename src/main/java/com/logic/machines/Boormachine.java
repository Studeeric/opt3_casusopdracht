package com.logic.machines;

import com.Database;

public class Boormachine extends Machine{
    private final String merk;
    private final String type;

    public Boormachine(String merk, String type){
        this.merk = merk;
        this.type = type;
        Database.addMachine(this);
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
