package com.gui;

import com.logic.CurrentSession;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class Controller implements PropertyChangeListener {
    protected CurrentSession currentSession;

    public void setCurrentSession(CurrentSession currentSession){
        this.currentSession = currentSession;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

}
