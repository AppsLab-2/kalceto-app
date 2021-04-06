package com.backend.backendkalceto.league;

import com.backend.backendkalceto.player.Player;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class League {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String leagueName;

    @ManyToMany(mappedBy = "leagues", cascade = CascadeType.ALL)
    @JsonManagedReference
    Set<Player> players;


    public League(String leagueName) {
        this.leagueName = leagueName;
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
}
