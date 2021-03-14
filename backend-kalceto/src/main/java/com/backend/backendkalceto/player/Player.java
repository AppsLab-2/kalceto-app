package com.backend.backendkalceto.player;

import com.backend.backendkalceto.league.League;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private long wins;
    private long losses;
    private long draws;
    private long goals;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "playersInLeagues",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "league_id"))
    Set<League> leagues;

    public Player(String name, long wins, long losses, long draws, long goals) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.goals = goals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWins() {
        return wins;
    }

    public void setWins(long wins) {
        this.wins = wins;
    }

    public long getLosses() {
        return losses;
    }

    public void setLosses(long losses) {
        this.losses = losses;
    }

    public long getDraws() {
        return draws;
    }

    public void setDraws(long draws) {
        this.draws = draws;
    }

    public long getGoals() {
        return goals;
    }

    public void setGoals(long goals) {
        this.goals = goals;
    }

    public Set<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(Set<League> leagues) {
        this.leagues = leagues;
    }
}
