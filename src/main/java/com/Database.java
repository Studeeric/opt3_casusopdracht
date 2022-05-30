package com;

import com.logic.machines.Machine;
import com.logic.Medewerker;

import java.util.ArrayList;
import java.util.List;

public abstract class Database {
    private static final List<Machine> machineList = new ArrayList<>();
    private static Integer machineId = 1;
    private static final List<Medewerker> medewerkerList = new ArrayList<>();

    public static void addMachine(Machine machine){
        machine.assignId(machineId++);
        machineList.add(machine);
    }

    public static void addMedewerker(Medewerker medewerker){
        medewerkerList.add(medewerker);
    }

    public static List<Machine> getMachineList() {
        return machineList;
    }

    public static List<Medewerker> getMedewerkerList() {
        return medewerkerList;
    }
}
