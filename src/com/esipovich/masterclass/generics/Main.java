package com.esipovich.masterclass.generics;

/**
 * @author Artem Esipovich 09.04.2018
 */

public class Main {

    // Create a generic class to implement a league table for a sport.
    // The class should allow teams to be added to the list, and store
    // a list of teams that belong to the league.
    //
    // Your class should have a method to print out the teams in order,
    // with the team at the top of the league printed first.
    //
    // Only teams of the same type should be added to any particular
    // instance of the league class - the program should fail to compile
    // if an attempt is made to add an incompatible team.

    public static void main(String[] args) {
        LeagueTable<FootballTeam> footballLeagueTable = new LeagueTable<>();
        LeagueTable<BasketballTeam> basketballLeagueTable = new LeagueTable<>();

        FootballTeam manchester = new FootballTeam("Manchester", 10);
        FootballTeam monreal = new FootballTeam("Monreal", 9);
        FootballTeam slutsk = new FootballTeam("Slutsk", 11);

        BasketballTeam strange = new BasketballTeam("Strange", 111);
        BasketballTeam other = new BasketballTeam("Other", 101);
        BasketballTeam another = new BasketballTeam("Another", 114);
        BasketballTeam same = new BasketballTeam("Another", 112);

        footballLeagueTable.addTeam(manchester);
        footballLeagueTable.addTeam(monreal);
        footballLeagueTable.addTeam(slutsk);

        footballLeagueTable.printTeams();

        basketballLeagueTable.addTeam(strange);
        basketballLeagueTable.addTeam(other);
        basketballLeagueTable.addTeam(another);
        basketballLeagueTable.addTeam(same);

        basketballLeagueTable.printTeams();
    }
}
