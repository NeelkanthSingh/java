package com.nitrousoxide;

public class Cat extends Animal{
    private String name;

    public Cat(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "meow";
    }

}
