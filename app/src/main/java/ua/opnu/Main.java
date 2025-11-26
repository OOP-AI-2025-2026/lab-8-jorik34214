package ua.opnu;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // task 1
        System.out.println("=== MyOptional test ===");

        // 1. Порожній приклад
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);                           // MyOptional[empty]
        System.out.println(middleName.isPresent());               // false
        System.out.println(middleName.orElse("немає"));           // "немає"

        // 2. Заповнене значення
        MyOptional<String> login = new MyOptional<>("superuser");
        System.out.println(login);                                 // MyOptional[value=superuser]
        System.out.println(login.get());                           // "superuser"
        System.out.println(login.orElse("guest"));                 // "superuser"

        // 3. get() на пустому об'єкті
        try {
            middleName.get();
        } catch (Exception e) {
            System.out.println("Очікувано: " + e.getMessage());
        }

        // 4. Конструктор не приймає null
        try {
            MyOptional<String> invalid = new MyOptional<>(null);
        } catch (Exception e) {
            System.out.println("Правильно: " + e.getMessage());
        }

        // task 2
        System.out.println("\n=== BookData Comparable ===");

        BookData book1 = new BookData("Kotlin", "Maria", 80, 360);
        BookData book2 = new BookData("JavaScript", "Oleg", 60, 270);
        BookData book3 = new BookData("Scala", "Diana", 80, 360);

        BookData[] books = {book1, book2, book3};
        Arrays.sort(books);

        for (BookData b : books)
            System.out.println(b);

        // task 3
        System.out.println("\n=== Printer.printArray ===");

        Printer printer = new Printer();
        Integer[] numbers = {10, 20, 30};
        String[] greetings = {"Hi", "Everyone"};

        printer.printArray(numbers);
        printer.printArray(greetings);

        // task 4
        System.out.println("\n=== Utils.filter ===");

        Integer[] values = {5, 12, 7, 20, 3};
        Integer[] greaterThanTen = Utils.filter(values, x -> x > 10);

        for (int val : greaterThanTen)
            System.out.println(val);

        // task 5
        System.out.println("\n=== Utils.contains ===");

        String[] fruits = {"Apple", "Banana", "Cherry"};
        System.out.println(Utils.contains(fruits, "Banana")); // true
        System.out.println(Utils.contains(fruits, "Orange")); // false

        // task 6
        System.out.println("\n=== GenericTwoTuple / GenericThreeTuple ===");

        GenericTwoTuple<String, Integer> laptop =
                new GenericTwoTuple<>("Lenovo", 1500);

        GenericThreeTuple<String, Integer, Double> phone =
                new GenericThreeTuple<>("Samsung", 900, 7.99);

        System.out.println(laptop);
        System.out.println(phone);
    }
}

