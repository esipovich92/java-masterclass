package com.esipovich.masterclass.set;

/**
 * @author Artem Esipovich 09.04.2018
 */

public class Moon extends HeavenlyBody {

    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.MOON);
    }
}
