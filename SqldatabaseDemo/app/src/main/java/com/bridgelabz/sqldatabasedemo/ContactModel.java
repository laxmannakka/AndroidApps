package com.bridgelabz.sqldatabasedemo;

/**
 * Created by bridgelabz1 on 8/6/16.
 */
public class ContactModel {
    private  String name;
    private  String number;
    private int id;

    public String getId() {
        return String.valueOf(id);
    }

    public void setId(int id) {
        this.id = id;
    }


    public ContactModel(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public ContactModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
