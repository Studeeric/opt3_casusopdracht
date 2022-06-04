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


    @Override
    public String getClassType(){
        return "Boormachine";
    }

    @Override
    public void setInfo1(String info1) {
        this.merk = info1;
    }

    @Override
    public void setInfo2(String info2) {
        this.type = info2;
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

    @Override
    public boolean isInfoType1String() {
        return true;
    }

    @Override
    public boolean isInfoType2String() {
        return true;
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
