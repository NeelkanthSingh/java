package com.nitrousoxide;

public class Cat {
    private String name;

    public Cat(String name) {
        this();
        this.name = name;
    }

    public Cat() {
        this.name = "No Name";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void meaw() {
        System.out.println(this.name + ": Meaw");
    }

    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
