package com.nitrousoxide;

public class Main {
    public static void main(String[] args) {
        String grade = "A";

        String result = switch (grade) {
            case "A" -> "Excellent";
            case "B" -> "Good";
            default -> "Not good";
        };

        Day day = Day.valueOf("MONDAY");
        for (Day d : Day.values()) {
            System.out.println(d);
        }
        System.out.println(day.ordinal());

        // Implicit Type (Widening) Casting
        int i = 5;
        double d = i;
        System.out.println(d);

        // Explicit Type (Narrowing) Casting
        double d2 = 5.5;
        int i2 = (int) d2;
        System.out.println(i2);

        // Wrapper Classes
        Integer i3 = 5;
        System.out.println(i3);
        System.out.println(i3.toString());
        System.out.println(Integer.parseInt("5"));
    }
}