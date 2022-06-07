package com.logic.machines;

public class VrachtAuto extends Machine{

    public VrachtAuto() {
        super();
        addToDatabase();
    }

    @Override
    public String getClassType(){
        return "VrachtAuto";
    }

    @Override
    protected void setPropertyTypes() {
        properties[0] = new Property("Laadvermogen", null, true);
        properties[1] = new Property("Gewicht", null, true);
    }

    @Override
    public double getHuurPrijs() {
        return 0.10 * Double.parseDouble(properties[0].getPropertyValue());
    }

    @Override
    public double getVerzekeringPrijs() {
        return 0.01 * Double.parseDouble(properties[1].getPropertyValue());
    }
}
