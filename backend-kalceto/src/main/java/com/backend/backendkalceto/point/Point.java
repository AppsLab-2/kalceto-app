package com.backend.backendkalceto.point;

import com.backend.backendkalceto.league.League;
import com.backend.backendkalceto.player.Player;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Point{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private long points;
    private long position;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="league_id", nullable=false, insertable = false, updatable = false)
    private League league1;

    @Column(name = "league_id")
    private long leagueId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="player_id", nullable=false, insertable = false, updatable = false)
    private Player playerPoint;

    @Column(name = "player_id")
    private long playerId;

    public Point() {
        this.points = 0;
    }

    public Point(long leagueId, long playerId, long points, long position) {
        this.leagueId = leagueId;
        this.playerId = playerId;
        this.points = points;
        this.position = position;
    }


    public long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(long leagueId) {
        this.leagueId = leagueId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public League getLeague1() {
        return league1;
    }

    public void setLeague1(League league1) {
        this.league1 = league1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Player getPlayerPoint() {
        return playerPoint;
    }

    public void setPlayerPoint(Player playerPoint) {
        this.playerPoint = playerPoint;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

}
