package com.logic;

public class Huur {
    private final String klantNaam;
    private final int dagen;
    private final Medewerker medewerker;
    private final boolean verzekering;

    public Huur(Medewerker medewerker, String klantNaam, int dagen, boolean verzekering){
        this.medewerker = medewerker;
        this.klantNaam = klantNaam;
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

    public boolean isVerzekering(){
        return verzekering;
    }
}
