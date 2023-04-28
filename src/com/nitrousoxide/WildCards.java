package com.nitrousoxide;

import java.util.List;

public class WildCards {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3};
        String[] strings = {"a", "b", "c"};
        print(List.of(ints));
        print(List.of(strings));
    }

    static void print(List<?> list) {
        list.forEach(System.out::println);
    }
}
