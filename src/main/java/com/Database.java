package com;

import com.gui.Controller;
import com.logic.Medewerker;
import com.logic.machines.Machine;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public abstract class Database {
    private static final List<Machine> machineList = new ArrayList<>();
    private static Integer machineId = 1;
    private static final List<Medewerker> medewerkerList = new ArrayList<>();

    static final private PropertyChangeSupport pcs = new PropertyChangeSupport(Database.class);

    public static void addObserver(PropertyChangeListener l){
        pcs.addPropertyChangeListener("machineList", l);
    }

    public static void setProperty(Machine machine) {
        List<Machine> old = new ArrayList<>(machineList);
        machine.assignId(machineId++);
        machineList.add(machine);
        pcs.firePropertyChange("machineList", old, machineList);
    }

    public static void removeProperty(Machine machine) {
        List<Machine> old = new ArrayList<>(machineList);
        machineId--;
        machineList.remove(machine);
        pcs.firePropertyChange("machineList", old, machineList);
    }

    public static void addObserversToMachines(Controller controller){
        for (Machine machine : machineList){
            machine.addObserver(controller);
        }
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
