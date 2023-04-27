package com.nitrousoxide;

public class Phone {
    private final String brand;

    public Phone(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }

    @Override
    public String toString() {
        return "Phone(" + this.brand + ")";
    }
}
