package com.logic.machines;

public class PersonenAuto extends Machine{

    public PersonenAuto() {
        super();
        addToDatabase();
    }

    @Override
    public String getClassType(){
        return "PersonenAuto";
    }

    @Override
    protected void setPropertyTypes() {
        properties[0] = new Property("Merk", null, false);
        properties[1] = new Property("Gewicht", null, true);
    }

    @Override
    public double getHuurPrijs(){
        return 50;
    }
    @Override
    public double getVerzekeringPrijs() {
        return Double.parseDouble(properties[1].getPropertyValue());
    }
}
