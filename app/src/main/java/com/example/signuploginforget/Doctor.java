package com.example.signuploginforget;

import android.widget.EditText;

public class Doctor {
    private String id ;
    private String name;
   private String location ;
    private String specialty;

    public Doctor() {
    }

    public Doctor(String id, String name, String location, String specialty) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.specialty = specialty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
