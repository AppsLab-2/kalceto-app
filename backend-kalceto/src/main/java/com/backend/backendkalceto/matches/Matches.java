package com.backend.backendkalceto.matches;

import com.backend.backendkalceto.league.League;
import com.backend.backendkalceto.matches.Matches;
import com.backend.backendkalceto.player.Player;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import javax.persistence.*;
import java.util.Set;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Matches {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private long player1Score;
    private long player2Score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="league_id", nullable=false, insertable = false, updatable = false)
    private League league;

    @Column(name = "league_id")
    private long leagueId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="player1_id", nullable=false, insertable = false, updatable = false)
    private Player player1;

    @Column(name = "player1_id")
    private long player1Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="player2_id", nullable=false, insertable = false, updatable = false)
    private Player player2;

    @Column(name = "player2_id")
    private long player2Id;

    public Matches() {}

    public Matches(long id, long player1Score, long player2Score, League league, long leagueId, Player player1, long player1Id, Player player2, long player2Id) {
        this.id = id;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.league = league;
        this.leagueId = leagueId;
        this.player1 = player1;
        this.player1Id = player1Id;
        this.player2 = player2;
        this.player2Id = player2Id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public long getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(long player1Score) {
        this.player1Score = player1Score;
    }

    public long getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(long player2Score) {
        this.player2Score = player2Score;
    }

    public long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(long leagueId) {
        this.leagueId = leagueId;
    }

    public long getPlayer1Id() {
        return player1Id;
    }

    public void setPlayer1Id(long player1Id) {
        this.player1Id = player1Id;
    }

    public long getPlayer2Id() {
        return player2Id;
    }

    public void setPlayer2Id(long player2Id) {
        this.player2Id = player2Id;
    }
}
