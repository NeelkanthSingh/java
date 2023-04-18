package com.nitrousoxide;

public class Main {
    public static void main(String[] args) {
        String grade = "A";

        String result = switch (grade) {
            case "A" -> "Excellent";
            case "B" -> "Good";
            default -> "Not good";
        };

        // enum example, values() exmaple, and ordinal() example
        Day day = Day.valueOf("MONDAY");
        for (Day d : Day.values()) {
            System.out.println(d);
        }
        System.out.println(day.ordinal());

        // switch expression example


        System.out.println(result);

    }
}