package com.backend.backendkalceto.point;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Point {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private long leagueId;
    private long playerId;
    private long points;

    public Point() {
        this.points = 0;
    }

    public Point(long leagueId, long playerId, long points) {
        this.leagueId = leagueId;
        this.playerId = playerId;
        this.points = points;
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
}
