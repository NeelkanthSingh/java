package com.nitrousoxide;

import java.util.Arrays;
import java.util.List;

public class WildCards {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);
//        print(ints);
        print(doubles);
    }

    static void print(List<? super Double> list) {
        list.forEach(System.out::println);
    }
}
