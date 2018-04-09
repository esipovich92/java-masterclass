package com.esipovich.masterclass.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Artem Esipovich 09.04.2018
 */

public class LeagueTable<T extends Team> {

    private List<T> teams;

    public LeagueTable() {
        teams = new ArrayList<>();
    }

    public void addTeam(T team) {
        T teamToAdd = findTeam(team);
        if (teamToAdd == null) {
            teams.add(team);
            System.out.println(team.getClass().getSimpleName() + " " + team.getName() + " was added");
        } else {
            System.out.println(team.getClass().getSimpleName() + " " + team.getName() + " already exists!");
        }
    }

    private T findTeam(T team) {
        for (T existingTeam : this.teams) {
            if (team.getName().equals(existingTeam.getName())) {
                return existingTeam;
            }
        }
        return null;
    }


    public void printTeams() {
        Collections.sort(this.teams);
        for (T team : teams) {
            System.out.println(team);
        }
    }
}
