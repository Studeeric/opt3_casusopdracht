package com.logic;

import com.Database;

public class Medewerker {
    private final String username;
    private final String password;

    public Medewerker(String username, String password){
        this.username = username;
        this.password = password;
        Database.addMedewerker(this);
    }

    public String getUsername(){
        return this.username;
    }

    public boolean checkPassword(String password){
        return password.equals(this.password);
    }
}
