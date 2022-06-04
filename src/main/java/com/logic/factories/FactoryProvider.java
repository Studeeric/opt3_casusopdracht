package com.logic.factories;

public class FactoryProvider {
    public static AbstractFactory getFactory(String choice){

        if ("Machines".equalsIgnoreCase(choice)){
            return new MachineFactory();
        }
        return null;
    }
}
