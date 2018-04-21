package com.esipovich.masterclass.junits;

/**
 * @author Artem Esipovich 21.04.2018
 *
 * 1. Create a JUnit test class that contains a test method for each method in the Utilities class
 * 2. Add test code to the removePairs() method
 * 3. Add a test for the everyNthChar() method
 * 4. Add a test for the case when n is greater than the length of the array
 * 5. Add a test for the nullIfOddLength
 * 6. Add a test for converter
 */

public class Main {

    public static void main(String[] args) {

        Utilities utilities = new Utilities();
        System.out.println(utilities.removePairs("AA"));
    }
}
