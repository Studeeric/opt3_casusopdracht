package com.gui;

import com.logic.CurrentSession;

import java.beans.PropertyChangeListener;

public abstract class Controller implements PropertyChangeListener {
    protected CurrentSession currentSession = new CurrentSession();

    public void setCurrentSession(CurrentSession currentSession){
        this.currentSession = currentSession;
    }

}
