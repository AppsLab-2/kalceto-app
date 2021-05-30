package com.backend.backendkalceto.dto;

import lombok.Data;

@Data
public class PlayerDto {
    private long id;
    private String username;
    private String password;
    private long wins;
    private long losses;
    private long draws;
    private long goals;
    private long points;

    public PlayerDto(long id, String username, String password, long wins, long losses, long draws, long goals, long points) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.goals = goals;
        this.points = points;
    }
}
