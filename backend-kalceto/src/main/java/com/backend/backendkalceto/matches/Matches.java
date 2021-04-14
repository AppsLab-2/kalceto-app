package com.backend.backendkalceto.matches;

import com.backend.backendkalceto.league.League;
import com.backend.backendkalceto.player.Player;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;


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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="player1_id", nullable=false, insertable = false, updatable = false)
    private Player player1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="player2_id", nullable=false, insertable = false, updatable = false)
    private Player player2;


    public Matches() {}

    public Matches(long id, long player1Score, long player2Score, League league) {
        this.id = id;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.league = league;
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
}
