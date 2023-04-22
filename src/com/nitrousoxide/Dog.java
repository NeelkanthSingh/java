package com.nitrousoxide;

public class Dog extends Animal{
    private String name;

    public Dog(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "woof";
    }

}

