package com.backend.backendkalceto.league;

import com.backend.backendkalceto.matches.Matches;
import com.backend.backendkalceto.player.Player;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class League {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String leagueName;

    @OneToMany(mappedBy="league")
    private Set<Matches> matches;

    @ManyToMany(mappedBy = "leagues", cascade = CascadeType.ALL)
    Set<Player> players;


    public League(long id, String leagueName, Set<Matches> matches) {
        this.id = id;
        this.leagueName = leagueName;
        this.matches = matches;
    }

    public League() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Set<Matches> getMatches() {
        return matches;
    }

    public void setMatches(Set<Matches> matches) {
        this.matches = matches;
    }
}
