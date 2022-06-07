package com.logic.machines;

import com.Database;
import com.logic.Huur;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class Machine {
    protected Integer id;
    protected Huur huur;
    protected Property[] properties = new Property[2];

    final protected PropertyChangeSupport PCS = new PropertyChangeSupport(this);

    protected Machine(){
        setPropertyTypes();
    }

    public void addObserver(PropertyChangeListener l){
        PCS.addPropertyChangeListener("huur", l);
    }

    public void setHuur(Huur huur){
        Huur old = this.huur;
        this.huur = huur;
        PCS.firePropertyChange("huur", old, huur);
    }

    public void addToDatabase() {
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

    @SuppressWarnings("unused")
    public String getMachineInfo(){
        return "ID: " + getId();
    }

    protected abstract void setPropertyTypes();

    public Property getProperty(int index){
        return properties[index];
    }

    public abstract double getHuurPrijs();

    public abstract double getVerzekeringPrijs();

    public Boolean getHuurStatus(){
        return huur != null;
    }

    @SuppressWarnings("unused")
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
