package com.logic;

import com.Database;

public class Medewerker {
    private final String USERNAME;
    private final String PASSWORD;

    public Medewerker(String username, String password){
        this.USERNAME = username;
        this.PASSWORD = password;
        Database.addMedewerker(this);
    }

    public String getUsername(){
        return this.USERNAME;
    }

    public boolean checkPassword(String password){
        return password.equals(this.PASSWORD);
    }
}
