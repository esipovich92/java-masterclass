package com.esipovich.masterclass.set;

/**
 * @author Artem Esipovich 09.04.2018
 */

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if(moon.getKey().getBodyType() == BodyTypes.MOON) {
            return super.addSatellite(moon);
        } else {
            return false;
        }
    }
}
