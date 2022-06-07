package com.logic.factories;

public class FactoryProvider {
    @SuppressWarnings("rawtypes")
    public static AbstractFactory getFactory(String choice){

        if ("Machines".equalsIgnoreCase(choice)){
            return new MachineFactory();
        }
        return null;
    }
}
