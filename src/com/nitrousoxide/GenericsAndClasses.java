package com.nitrousoxide;

public class GenericsAndClasses {
    public static void main(String[] args) {
        Box<Letter> letterBox = new Box<Letter>();
        Box<Phone> phoneBox = new Box<Phone>();
        letterBox.set(new Letter("John Doe"));
        phoneBox.set(new Phone("Apple"));
        System.out.println(letterBox.get());
        System.out.println(phoneBox.get());
    }
}
