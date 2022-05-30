package com.logic.machines;

import com.logic.Huur;
import com.logic.Medewerker;

public abstract class Machine {
    private Integer id;

    private Huur huur;

    public void setHuur(Medewerker medewerker, String klantNaam, int dagen, boolean verzekering){
        this.huur = new Huur(medewerker, klantNaam, dagen, verzekering);
    }

    public Huur getHuur(){
        return this.huur;
    }

    public void removeHuur(){
        this.huur = null;
    }

    public double getTotaalPrijs(int dagen, boolean verzekerd){
        double totaalPrijs = dagen * getHuurPrijs();
        if (verzekerd)
            totaalPrijs += dagen * getVerzekeringPrijs();
        return totaalPrijs;
    }

    public abstract String getClassType();

    public Integer getId(){
        return this.id;
    }

    public String getMachineInfo(){
        return "ID: " + getId() + " - Soort: " + getClassType();
    }

    public abstract double getHuurPrijs();

    public abstract double getVerzekeringPrijs();

    public Boolean getHuurStatus(){
        return huur != null;
    }

    public String getHuurStatusString(){
        if (huur != null){
            return "Verhuurd";
        }
        return "Beschikbaar";
    }

    public void assignId(Integer id){
        this.id = id;
    }
}
