package com.esipovich.masterclass.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Artem Esipovich 22.04.2018
 *
 * 1. Write a regular expression that will match "I want a bike"
 * 2. Regexp that will math text1 and text2
 * 3. The same using Pattern and Matches
 * 4. Write a regex that will match "aaabccccccdddeefffg" in its entirety
 * 5. Write a regex that will match only "aaabccccccdddeefffg" in its entirety
 * 6. Write a regex that will match a string that starts with a series of letters that must be followed by a period
 * ex. kjisl.22, abcd.135
 */

public class Main {

    private static String text1 = "I want a bike.";
    private static String text2 = "I want a ball.";
    private static String text3 = "aaabccccccdddeefffg";
    private static String text4 = "abcd.135";

    public static void main(String[] args) {
        System.out.println("Task #1");
        System.out.println(taskOne(text1));

        System.out.println("Task #2");
        System.out.println(taskTwo(text1));
        System.out.println(taskTwo(text2));

        System.out.println("Task #3");
        System.out.println(taskThree(text1));
        System.out.println(taskThree(text2));

        System.out.println("Task #4");
        System.out.println(taskFour(text3));

        System.out.println("Task #5");
        System.out.println(taskFive(text3));

        System.out.println("Task #6");
        System.out.println(taskSix(text4));
    }


    private static boolean taskOne(String text) {
        return text.matches(".*");
    }

    private static boolean taskTwo(String text) {
        return text.matches("I want a \\w+.");
    }

    private static boolean taskThree(String text) {
        String rexExp = "I want a \\w+.";
        Pattern pattern = Pattern.compile(rexExp);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    private static boolean taskFour(String text) {
//        return text.matches("[abcdefg]+");
        return text.matches("[a-g]+");
    }

    private static boolean taskFive(String text) {
        return text.matches("^a{3}bc{6}d{3}e{2}f{3}g$");
    }

    private static boolean taskSix(String text){
        return text.matches("^[a-zA-Z]+\\.\\d+$");
    }
}
