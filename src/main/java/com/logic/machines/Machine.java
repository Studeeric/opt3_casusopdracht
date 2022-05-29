package com.logic.machines;

import com.Database;

public abstract class Machine {
    private Boolean wordtVerhuurd = false;

    public double getTotaalPrijs(int dagen, boolean verzekerd){
        double totaalPrijs = dagen * getHuurPrijs();
        if (verzekerd)
            totaalPrijs += dagen * getVerzekeringPrijs();
        return totaalPrijs;
    }

    public abstract String getClassType();

    public abstract String getMachineInfo();

    public abstract double getHuurPrijs();

    public abstract double getVerzekeringPrijs();

    public Boolean getWordtVerhuurd(){
        return wordtVerhuurd;
    }

    public void setVerhuur(boolean verhuur){
        wordtVerhuurd = verhuur;
    }
}
