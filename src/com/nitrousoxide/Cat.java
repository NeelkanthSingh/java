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

    @Override // This is just for the readability of the code, no effect on the program
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
