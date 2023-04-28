package com.nitrousoxide;

public class GenericAndMethods {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"a", "b", "c"};
        print(intArray);
        print(stringArray);

        Integer[] intArray2 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(print(intArray2, 3));
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        System.out.println(print(doubleArray, 3.3));

    }

    static <T> void print(T[] array) {
        for (T e: array) {
            System.out.println(
                    e.getClass().getName() + ": " +
                            " - " + e
            );
        }
    }

    static <T extends Comparable<T>> int print(T[] t, T n){
        int count=0;
        for (T e: t) {
            if(e.compareTo(n)>0){
                count++;
            }
        }
        return count;
    }

}
