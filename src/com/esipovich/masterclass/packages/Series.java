package com.esipovich.masterclass.packages;

/**
 * @author Artem Esipovich 09.04.2018
 */

public class Series {

    public static long nSum(int n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long factorial(int n) {
        long result = 1;
        for (long i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
