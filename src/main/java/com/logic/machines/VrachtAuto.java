package com.logic.machines;

public class VrachtAuto extends Machine{

    public VrachtAuto() {
        super();
    }

    @Override
    public String getClassType(){
        return "VrachtAuto";
    }

    @Override
    protected void setPropertyTypes() {
        PROPERTIES[0] = new Property("Laadvermogen", null, true);
        PROPERTIES[1] = new Property("Gewicht", null, true);
    }

    @Override
    public double getHuurPrijs() {
        return 0.10 * Double.parseDouble(PROPERTIES[0].getPropertyValue());
    }

    @Override
    public double getVerzekeringPrijs() {
        return 0.01 * Double.parseDouble(PROPERTIES[1].getPropertyValue());
    }
}
