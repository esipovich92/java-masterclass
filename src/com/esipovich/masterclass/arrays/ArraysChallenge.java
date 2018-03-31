package com.esipovich.masterclass.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Artem Esipovich 31.03.2018
 */

public class ArraysChallenge {
    // Create a program using arrays that sorts a list of integers in descending order.
    // Descending order is highest value to lowest.
    // In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
    // ultimately have an array with 106,81,26, 15, 5 in it.
    // Set up the program so that the numbers to sort are read in from the keyboard.
    // Implement the following methods - getIntegers, printArray, and sortIntegers
    // getIntegers returns an array of entered integers from keyboard
    // printArray prints out the contents of the array
    // and sortIntegers should sort the array and return a new array containing the sorted numbers
    // you will have to figure out how to copy the array elements from the passed array into a new
    // array and sort them and return the new sorted array.

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = readArray(10);
        System.out.print("Array before sort: ");
        printArray(array);
        sortDescending(array);
        System.out.print("Array after sort: ");
        printArray(array);
    }

    private static int[] readArray(int size) {
        System.out.println("Please enter " + size + " integer elements:");
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        return array;
    }

    private static void sortDescending(int[] array) {
        int[] newArray = Arrays.copyOf(array, array.length);
        int temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] < array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " | ");
        }
        System.out.println();
    }
}
