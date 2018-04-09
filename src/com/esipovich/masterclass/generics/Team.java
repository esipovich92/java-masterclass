package com.esipovich.masterclass.generics;

/**
 * @author Artem Esipovich 09.04.2018
 */

public abstract class Team implements Comparable<Team> {

    protected String name;
    protected int point;

    public Team(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public int compareTo(Team teamToCompare) {
        if (this.point > teamToCompare.getPoint()) {
            return 1;
        }
        if (this.point == teamToCompare.getPoint()) {
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": name = " + name + ", point = " + point +"}";
    }
}
