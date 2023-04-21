package com.nitrousoxide;

import com.nitrousoxide.exception.MyCheckedException;
import com.nitrousoxide.exception.MyUncheckedException;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

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
        LocalDateTime ldt2 = LocalDateTime.now(zoneId);
        System.out.println(ldt2);

        // LocalDateTime Instant ZoneDateTime
        Instant instant = Instant.now();
        System.out.println(instant);
        ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.of("America/Los_Angeles"));
        System.out.println(zonedDateTime2);

        // Scanner Class
        Scanner scanner = new Scanner(System.in);
        System.out.print("Age: ");
        byte age = scanner.nextByte();
        System.out.println("You are " + age);
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.println("You are " + name);
        scanner.close();

        // Exception Handling with Multiple errors
        try {
            int[] numbers = { 1, 2, 3 };
            System.out.println(numbers[4]);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // Custom Exception
        try {
            int[] numbers = { 1, 2, 3 };
            System.out.println(numbers[4]);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Finally always runs");
        }

        // Checked Exceptions
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Unchecked Exceptions
//        int result2 = 10 / 0; // Checked Exception
        // Resolving a Checked exception
        try {
            int result2 = 10 / 0;
            System.out.println(result2);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            divide(4,0);
        } catch (MyCheckedException e) {
            e.printStackTrace();
        }

        // Working on Files

        try {
            File file = new File("src/test.txt");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            e.getMessage();
        }

        try {
            File file = createAFile();
            writeToAFIle(file, "Hello World", false);
            writeToAFIle(file, "Hello Guys", true);
            readFromAFile(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Class Constructors
        Cat cat = new Cat("Tom");
        Cat rose = new Cat();
        cat.setName("Tom");
    }

    private static void readFromAFile(File file){
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeToAFIle(File file, String text, boolean append) throws IOException {

        try(FileWriter fw = new FileWriter(file, append);
            PrintWriter pw = new PrintWriter(fw);
            )
        {
            pw.println(text);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    private static File createAFile(){
        try{
            File file = new File("src/test.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            return file;
        }catch (IOException e){
            e.getMessage();
        }
        return null;
    }

    public static void divide(int x, int y) throws MyCheckedException {
        if (y == 0) {
//            throw new MyUncheckedException("Cannot divide by zero");
            throw new MyCheckedException("Cannot divide by zero");
        }
        System.out.println(x / y);
    }
}