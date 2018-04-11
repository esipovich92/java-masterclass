package com.esipovich.masterclass.set;

/**
 * @author Artem Esipovich 09.04.2018
 */

public class DwarfPlanet extends HeavenlyBody {

    public DwarfPlanet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.DWARF_PLANET);
    }
}
