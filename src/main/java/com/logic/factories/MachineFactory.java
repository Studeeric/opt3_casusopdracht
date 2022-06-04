package com.logic.factories;

import com.logic.machines.Boormachine;
import com.logic.machines.Machine;
import com.logic.machines.PersonenAuto;
import com.logic.machines.VrachtAuto;

import java.io.IOException;

public class MachineFactory implements AbstractFactory<Machine> {


    @Override
    public Machine create(String type) throws IOException {
        if ("Boormachine".equalsIgnoreCase(type)){
            return new Boormachine();
        } else if ("Personenauto".equalsIgnoreCase(type)) {
            return new PersonenAuto();
        } else if ("Vrachtauto".equalsIgnoreCase(type)) {
            return new VrachtAuto();
        }
        return null;
    }
}
