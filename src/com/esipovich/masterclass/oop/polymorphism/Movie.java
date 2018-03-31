package com.esipovich.masterclass.oop.polymorphism;

/**
 * @author Artem Esipovich 28.03.2018
 */

public class Movie {

    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot() {
        return "No plot here";
    }

    public String getName() {
        return name;
    }
}

class Jaws extends Movie {

    public Jaws() {
        super("Jaws");
    }

    public String plot() {
        return "A shark eats lots of people";
    }

}

class IndependenceDay extends Movie {

    public IndependenceDay() {
        super("Independence Day");
    }

    public String plot() {
        return "Aliens attempt to take over planet earth";
    }
}

class MazeRunner extends Movie {

    public MazeRunner() {
        super("Maze runner");
    }

    public String plot() {
        return "Kids try and escape a maze";
    }
}

class StarWars extends Movie {

    public StarWars() {
        super("Star Wars");
    }

    public String plot() {
        return "Imperial forces try to take over universe";
    }
}

class Forgetable extends Movie {

    public Forgetable() {
        super("Forgetable");
    }
}

