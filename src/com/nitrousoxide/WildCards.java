package com.nitrousoxide;

import java.util.List;

public class WildCards {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3};
        Double[] doubles = {1.1, 2.2, 3.3};
        print(List.of(ints));
        print(List.of(doubles));
    }

    static void print(List<? extends Number> list) {
        list.forEach(System.out::println);
    }
}
