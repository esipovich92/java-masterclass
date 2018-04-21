package com.esipovich.masterclass.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Artem Esipovich 20.04.2018
 *
 * 1. Rewrite an anonymous class to lambda
 * 2. Rewrite a method to lambda
 * 3. Write the code that will execute the function from task#2 with an argument of "1234567890"
 * 4. Write a method everySecondCharacter that accepts a function as a parameter
 * 5. Write a lambda that maps to java.util.Supplier
 * 6. Write code to print items in the list in sorted order, and with the first letter in each name in upper-case
 * 7. Like 6 but with streams
 * 8. Print how many names start with A
 */

public class Main {

    private static List<String> names = Arrays.asList(
            "Amela", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack", "Charlie", "harry", "Jacob"
    );

    public static void main(String[] args) {
        //#1
        Runnable usualRunnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split it out into an array";
                String[] parts = myString.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Runnable lambdaRunnable = () -> {
            String myString = "Let's split it out into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        //#2
        Function<String, String> function = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        //#3
        System.out.println(function.apply("1234567890"));

        //#4
        System.out.println(everySecondChar("1234567890", function));

        //#5
        Supplier<String> iLoveJava = () -> "I love java!";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        //#6
        List<String> namesUpperCase = new ArrayList<>();
        names.forEach(name -> namesUpperCase.add(name.substring(0, 1).toUpperCase() + name.substring(1)));
        namesUpperCase.sort(String::compareTo);
        namesUpperCase.forEach(System.out::println);

        //#7
        names.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        //#8
        System.out.println(
                names.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count());
    }

    //#2
    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    //#4
    public static String everySecondChar(String source, Function<String, String> function) {
        return function.apply(source);
    }
}
