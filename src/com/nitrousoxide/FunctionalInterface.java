package com.nitrousoxide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterface {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);

        // Predicate is a functional interface
        Predicate<Integer> isEven = e -> e % 2 == 0;

        list.
                stream().
                filter(isEven).
                forEach(System.out::println);

    }
}
