package com.logic.machines;

public class Property {
    private final String PROPERTY_TYPE;
    private String propertyValue;
    private final boolean NUMERIC;

    public Property(String property_type, String property, boolean numeric){
        this.PROPERTY_TYPE = property_type;
        this.propertyValue = property;
        this.NUMERIC = numeric;
    }

    public void setPropertyValue(String property){
        this.propertyValue = property;
    }

    public String getPROPERTY_TYPE(){
        return this.PROPERTY_TYPE;
    }

    public String getPropertyValue(){
        if (NUMERIC){
            double property = Double.parseDouble(propertyValue);
            return String.format("%.2f", property);
        } else {
            return propertyValue;
        }
    }

    public boolean isNUMERIC(){
        return this.NUMERIC;
    }
}
