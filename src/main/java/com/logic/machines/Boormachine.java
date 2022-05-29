package com.logic.machines;

import com.Database;

public class Boormachine extends Machine{
    private String merk;
    private String type;

    public Boormachine(String merk, String type){
        this.merk = merk;
        this.type = type;
        Database.machineList.add(this);
    }

    public String getMerk() {
        return merk;
    }

    public String getType() {
        return type;
    }

    public String getClassType(){
        return "Boormachine";
    }

    public String getMachineInfo(){
        return "Merk: " + merk + " | Type: " + type;
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
