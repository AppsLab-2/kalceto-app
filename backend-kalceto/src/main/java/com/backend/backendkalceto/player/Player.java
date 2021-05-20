package com.backend.backendkalceto.player;

import com.backend.backendkalceto.league.League;
import com.backend.backendkalceto.matches.Matches;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Player {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private long wins;
    private long losses;
    private long draws;
    private long goals;
    private  long points;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "players_leagues",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "league_id"))
    Set<League> leagues;

    @OneToMany(mappedBy="player1")
    private Set<Matches> matches1;

    @OneToMany(mappedBy="player2")
    private Set<Matches> matches2;

    @OneToMany(mappedBy="player")
    private Set<League> league;

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.goals = 0;
        this.points = 0;
    }

    public Player() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }
}
