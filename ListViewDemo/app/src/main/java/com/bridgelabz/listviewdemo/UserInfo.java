package com.bridgelabz.listviewdemo;

import android.widget.Spinner;

/**
 * Created by bridgelabz1 on 6/6/16.
 */

// Class for UserInformation class
public class UserInfo {
    // Variables name and surname stores Name  And SurName
    private String name;
    private String surname;

    // for get the Name From list
    public String getName() {
        return name;
    }

    // set Name to List
    public void setName(String name) {
        this.name = name;
    }

    // for get The surname from a List
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Constructor for This Class
    public UserInfo(String name, String surname) {

        this.name = name;
        this.surname = surname;
    }
}

