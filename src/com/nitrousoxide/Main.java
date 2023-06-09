package com.nitrousoxide;

import com.nitrousoxide.exception.MyCheckedException;
import com.nitrousoxide.exception.MyUncheckedException;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class Main {

    public static int count1;

    static {
        count1 = 10;
        System.out.println("Static block");
    }

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
        cat.setName("Tom");

        System.out.println(cat);

        // Polymorphism

        System.out.println(1+1); // Here it adds the numbers
        System.out.println("1"+"1"); // Here it concatenates the strings

        Animal tomcat = new Cat("Tom"); // Here it is a Cat but it is an Animal
        Animal bruto = new Dog("Bruto"); // Here it is a Dog but it is an Animal

        // Optionals

        String text = null;
        Optional<String> optional = Optional.ofNullable(text);
        System.out.println(optional.isPresent());
        optional.ifPresentOrElse(s -> {
            System.out.println(s);
        }, () -> {
            System.out.println("No value");
        });

        // Garbage Collection
        Car car = new Car();
        car = null; // Here the car is not referenced anymore and it will be garbage collected

        Car mercedes = new Car();
        Car bmw = new Car();
        mercedes = bmw; // Here the mercedes is not referenced anymore and it will be garbage collected

        new Car(); // Here the car is not referenced anymore and it will be garbage collected

        System.gc(); // It forces the garbage collection to happen, though not necessarily immediately

        // Arrays
        int[] numbers = new int[5];
        int numbers2[] = {1,2,3,4,5};

        // 2D Arrays
        int[][] numbers3 = new int[2][3];
        int[][] numbers4 = {{1,2,3},{4,5,6}};
        int[][] numbers5 = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] numbers6 = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        };

        System.out.println(Arrays.toString(numbers2));
        System.out.println(Arrays.deepToString(numbers4));
        System.out.println(Arrays.deepToString(numbers5));
        System.out.println(Arrays.deepToString(numbers6));

        // Lists
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");

        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.size());
        System.out.println(list.contains("Hello"));
        System.out.println(list);

        for(String s : list){
            System.out.println(s);
        }

        list.forEach(System.out::println);

        List<String> list1 = List.of("Hello", "World"); // Immutable List

        System.out.println(list1);

        // Stack
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);

        // Queue
        Queue<String> queue = new LinkedList<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue);

        // LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.addFirst("c");
        ListIterator<String> listIterator = linkedList.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

        // Sets
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.forEach(System.out::println);
        System.out.println(set.size());

        // Maps
        Map<String, String> map = new HashMap<>();
        map.put("a", "Hello");
        map.put("b", "World");
        System.out.println(map.get("a"));
        map.entrySet().forEach(System.out::println);
        map.forEach((k,v) -> System.out.println(k + " " + v));

        // Generics
        List<String> list2 = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();

    }

    @SuppressWarnings("removal")
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage collected"); // Called just before the object is garbage collected
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