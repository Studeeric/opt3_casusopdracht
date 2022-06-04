package com.logic.machines;

import com.Database;
import com.Main;
import com.logic.Huur;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;

public abstract class Machine {
    private Integer id;

    private Huur huur;

    final private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addObserver(PropertyChangeListener l){
        pcs.addPropertyChangeListener("huur", l);
    }

    public void setProperty(Huur huur){
        Huur old = this.huur;
        this.huur = huur;
        pcs.firePropertyChange("huur", old, huur);
    }

    public void addToDatabase() throws IOException {
        Database.setProperty(this);
    }

    public Huur getHuur(){
        return this.huur;
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

    public abstract String getMachineInfo1();
    public abstract String getMachineInfo1Type();
    public abstract String getMachineInfo2();
    public abstract String getMachineInfo2Type();

    public abstract double getHuurPrijs();

    public abstract double getVerzekeringPrijs();

    public Boolean getHuurStatus(){
        return huur != null;
    }

    public String getHuurStatusString(){
        if (this.huur != null){
            return "Verhuurd";
        } else {
            return "Beschikbaar";
        }
    }

    public void assignId(Integer id){
        this.id = id;
    }

}
