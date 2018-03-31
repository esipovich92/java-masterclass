package com.esipovich.masterclass.oop.composition;

/**
 * @author Artem Esipovich 27.03.2018
 */

public class Resolution {

    private int width;
    private int height;

    public Resolution(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
