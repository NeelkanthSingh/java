package com.nitrousoxide;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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

        // String Builder
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        System.out.println(sb);
        System.out.println(sb.toString());

        // LocalDate and LocalDatetime
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.toString());
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getDayOfWeek());

        LocalTime time = LocalTime.now();
        System.out.println(time);
        System.out.println(time.toString());
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        System.out.println(dateTime.toString());
        System.out.println(dateTime.getYear());
        System.out.println(dateTime.getMonth());
        System.out.println(dateTime.getDayOfWeek());
        System.out.println(dateTime.getHour());
        System.out.println(dateTime.getMinute());
        System.out.println(dateTime.getSecond());

        // Formatting Date and Time
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(dtf.format(dateTime));

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(dtf2.format(dateTime));

        // Formatting Date and Time
        dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(dtf.format(dateTime));

        dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(dtf2.format(dateTime));

        // LocalDateTime of
        LocalDateTime ldt = LocalDateTime.of(2021, 1, 1, 10, 0);
        System.out.println(ldt);

        // LocalDateTime ZoneId
        ZoneId zoneId = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        System.out.println(zonedDateTime);
    }
}