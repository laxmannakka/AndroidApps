package com.bridgelabz.recycleviewdemo;

/**
 * Created by bridgelabz1 on 14/6/16.
 */
public class Employee {

    String name;
    String id;
    String designation;


    public Employee(String name, String id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
