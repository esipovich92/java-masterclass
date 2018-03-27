package com.esipovich.masterclass.section7.composition;

/**
 * @author Artem Esipovich 27.03.2018
 */

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20, 20, 5);
        Case theCase = new Case("2208", "Dell", "240", dimensions);


        Monitor monitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540, 1440));

        MotherBoard motherBoard = new MotherBoard("BJ-200", "Asus", 4, 6, "v2.44");

        PC pc = new PC(theCase, monitor, motherBoard);

        pc.powerUp();
    }
}
