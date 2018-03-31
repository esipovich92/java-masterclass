package com.esipovich.masterclass.oop.inheritance.lecture39_40;

/**
 * @author Artem Esipovich 25.03.2018
 */

public class Fish extends Animal{

    private int gills;
    private int eyes;
    private int fins;

    public Fish(String name, int size, int weight, int gills, int eyes, int fins) {
        super(name, 1, 1, size, weight);
        this.gills = gills;
        this.eyes = eyes;
        this.fins = fins;
    }

    private void rest() {

    }

    private void swim(int speed) {
        moveMuscles();
        moveBackFin();
        super.move(speed);
    }

    private void moveMuscles() {

    }

    private void moveBackFin() {

    }
}
