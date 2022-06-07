package com.logic.machines;

public class PersonenAuto extends Machine{

    public PersonenAuto() {
        super();
    }

    @Override
    public String getClassType(){
        return "PersonenAuto";
    }

    @Override
    protected void setPropertyTypes() {
        PROPERTIES[0] = new Property("Merk", null, false);
        PROPERTIES[1] = new Property("Gewicht", null, true);
    }

    @Override
    public double getHuurPrijs(){
        return 50;
    }
    @Override
    public double getVerzekeringPrijs() {
        return Double.parseDouble(PROPERTIES[1].getPropertyValue());
    }
}
