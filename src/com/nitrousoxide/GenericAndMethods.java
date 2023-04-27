package com.nitrousoxide;

public class GenericAndMethods {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"a", "b", "c"};
        print(intArray);
        print(stringArray);
    }

    static <T> void print(T[] array) {
        for (T e: array) {
            System.out.println(
                    e.getClass().getName() + ": " +
                            " - " + e
            );
        }
    }

}
