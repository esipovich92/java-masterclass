package com.esipovich.masterclass.oop.encapsulation;

import com.esipovich.masterclass.oop.encapsulation.without.Player;

/**
 * @author Artem Esipovich 27.03.2018
 */

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        player.name = "Tim";
        player.health = 20;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health " + player.healthRemaining());

        damage = 11;
        player.health = 200;
        player.loseHealth(damage);
        System.out.println("Remaining health " + player.healthRemaining());

        EnhancedPlayer enhancedPlayer = new EnhancedPlayer("Tim", 200, "Sword");
        System.out.println("Initial health is " + enhancedPlayer.getHealth());
    }
}
