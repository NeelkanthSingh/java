package com.nitrousoxide.combinatorpattern.lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
        Function<String, String> upperCaseName = String::toUpperCase;

        BiFunction<String, Integer, String> lowerCaseName = (name, age) -> {
            System.out.println(age);
            return name.toLowerCase();
        };

        System.out.println(lowerCaseName.apply("John", 90));
    }
}
