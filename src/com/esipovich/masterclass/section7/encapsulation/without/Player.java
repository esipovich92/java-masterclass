package com.esipovich.masterclass.section7.encapsulation.without;

/**
 * @author Artem Esipovich 27.03.2018
 */

public class Player {

    public String name;
    public int health;
    public String weapon;

    public void loseHealth(int damage) {
        this.health = this.health - damage;
        if (this.health <= 0) {
            System.out.println("Player knocked out");
        }
    }

    public int healthRemaining() {
        return this.health;
    }
}
