package com.bridgelabz.practicerecycleview;

/**
 * Created by bridgelabz1 on 14/6/16.
 */
public class StudentData {
    String Name;
    String id;
    String subject;

    public StudentData(String name, String id, String subject) {
        Name = name;
        this.id = id;
        this.subject = subject;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
