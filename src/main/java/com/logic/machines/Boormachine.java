package com.logic.machines;

public class Boormachine extends Machine{

    public Boormachine() {
        super();
        addToDatabase();
    }

    @Override
    public String getClassType(){
        return "Boormachine";
    }

    @Override
    protected void setPropertyTypes() {
        properties[0] = new Property("Merk", null, false);
        properties[1] = new Property("Type", null, false);
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
