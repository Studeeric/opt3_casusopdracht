package com.logic;

import com.logic.machines.Machine;

public class HuurRegel {
    private final String klantNaam;
    private final int dagen;
    private final Medewerker medewerker;
    private final Machine machine;
    private final boolean verzekering;

    public HuurRegel(Medewerker medewerker, String klantNaam, Machine machine, int dagen, boolean verzekering){
        this.medewerker = medewerker;
        this.klantNaam = klantNaam;
        this.machine = machine;
        this.dagen = dagen;
        this.verzekering = verzekering;
    }

    public String getKlantNaam() {
        return klantNaam;
    }

    public int getDagen() {
        return dagen;
    }

    public Medewerker getMedewerker() {
        return medewerker;
    }

    public Machine getMachine() {
        return machine;
    }

    public double getPrijs(){
        return this.machine.getTotaalPrijs(this.dagen, this.verzekering);
    }
}
