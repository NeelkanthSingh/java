package com.nitrousoxide;

public class Letter {

    private final String sender;

    public Letter(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return this.sender;
    }

    @Override
    public String toString() {
        return "Letter(" + this.sender + ")";
    }
}
