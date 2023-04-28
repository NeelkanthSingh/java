package com.nitrousoxide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.*;

public class FunctionalInterface {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);

        // Predicate
        Predicate<Integer> isOdd = e -> e % 2 != 0;
        Predicate<Integer> isMultipleOfThree = e -> e % 3 == 0;
        // Function
        Function<Integer,Integer> incrementByOneFunction = e -> e + 1;
        Function<Integer,Integer> multiplyByTenFunction = e -> e * 10;
        Function<Integer,Integer> incrementByOneAndMultiplyByTenFunction = incrementByOneFunction.andThen(multiplyByTenFunction);

        // BiFunction
        BiFunction<Integer,Integer,Integer> incrementByOneAndMultiplyByTenBiFunction = (e, n) -> (e + 1) * n;

        // Consumer
        Consumer<Integer> printAge = age -> System.out.println(age);

        // BiConsumer
        BiConsumer<Integer, String> printAgeAndName = (age, name) -> System.out.println(age + " " + name);

        // Supplier
        Supplier<List<Integer>> listSupplier = () -> new ArrayList<>(Arrays.asList(1, 2, 3));

        // Optional
        Optional.ofNullable(null)
                .ifPresentOrElse(System.out::println,
                () -> System.out.println("Value is null"));

        list.
                stream().
                filter(isOdd).
                forEach(System.out::println);

        listSupplier.get().forEach(System.out::println);
        System.out.println(isOdd.test(7));
        System.out.println(isOdd.and(isMultipleOfThree).test(7));
        System.out.println(isOdd.or(isMultipleOfThree).test(7));
        System.out.println(incrementByOneFunction.apply(7));
        System.out.println(incrementByOneAndMultiplyByTenFunction.apply(7));
        System.out.println(incrementByOneAndMultiplyByTenBiFunction.apply(7, 100));
        printAge.accept(7);
        printAgeAndName.accept(7, "John Doe");


    }
}
