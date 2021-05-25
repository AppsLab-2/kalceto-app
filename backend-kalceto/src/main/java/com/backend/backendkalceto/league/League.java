package com.backend.backendkalceto.league;

import com.backend.backendkalceto.matches.Matches;
import com.backend.backendkalceto.player.Player;
import com.backend.backendkalceto.point.Point;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="admin_id", nullable=false, insertable = false, updatable = false)
    private Player player;

    @Column(name = "admin_id")
    private long adminId;

    public League(long id, String leagueName, Set<Matches> matches, Set<Player> players, Player player, long adminId) {
        this.id = id;
        this.leagueName = leagueName;
        this.matches = matches;
        this.players = players;
        this.player = player;
        this.adminId = adminId;
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

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }
}
