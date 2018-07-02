package com.dexterlab.sahil.demo;

public class User {
    String id;
    String name;
    String number;
    String choice;

    public User () {

    }

    public User(String id, String name, String number, String choice) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.choice = choice;
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
}
