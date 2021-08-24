package com.shecodes.models;

public class Customer {
    String name;
    int nationalId;
    int id;
    String emailAddress;
    String residence;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int id) {
        this.nationalId = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    @Override
    public String toString() {
        return
                  name  +
                ", " + nationalId +
                ", " + emailAddress +
                ", " + residence
                ;
    }

}
