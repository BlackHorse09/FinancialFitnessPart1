package com.dexterlab.sahil.demo;

public class User {
    String id;
    String name;
    String number;
    String choice;
    String interest;

    public User () {

    }

    public User(String id, String name, String number, String choice,String interest) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.choice = choice;
        this.interest = interest;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getChoice() {
        return choice;
    }

    public String getInterest() {
        return interest;
    }
}
