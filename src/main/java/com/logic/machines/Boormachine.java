package com.logic.machines;

public class Boormachine extends Machine{

    public Boormachine() {
        super();
    }

    @Override
    public String getClassType(){
        return "Boormachine";
    }

    @Override
    protected void setPropertyTypes() {
        PROPERTIES[0] = new Property("Merk", null, false);
        PROPERTIES[1] = new Property("Type", null, false);
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
