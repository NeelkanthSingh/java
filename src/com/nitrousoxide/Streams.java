package com.nitrousoxide;

import java.util.List;

public class Streams {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1,2,3,6,89,4,5,6,7,8,9,0);

        ints.stream()
                .filter(i -> i>=7)
                .map(i -> i * 2)
                .forEach(System.out::println);
    }
}
