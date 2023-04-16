package com.nitrousoxide;

public class Main {
    public static void main(String[] args) {
        String grade = "A";

        String result = switch (grade) {
            case "A" -> "Excellent";
            case "B" -> "Good";
            default -> "Not good";
        };

        System.out.println(result);

    }
}