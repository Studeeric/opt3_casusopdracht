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

    @Override
    public double getHuurPrijs() {
        return 5;
    }

    @Override
    public double getVerzekeringPrijs() {
        return 1;
    }
}
