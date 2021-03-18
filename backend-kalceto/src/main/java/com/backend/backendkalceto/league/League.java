package com.backend.backendkalceto.league;

import com.backend.backendkalceto.player.Player;

import javax.persistence.*;
import java.util.Set;

@Entity
public class League {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String leagueName;

    @ManyToMany(mappedBy = "leagues", cascade = CascadeType.ALL)
    Set<Player> players;


    public League(String leagueName) {
        this.leagueName = leagueName;
    }
    public League() {}

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
