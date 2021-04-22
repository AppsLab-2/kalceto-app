package com.backend.backendkalceto.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(value = "/addPlayer")
    public void addPlayer(@RequestBody Player player){
        playerService.savePlayer(player);
    }

    @PostMapping(value = "/setPlayerGoals")
    public void setPlayerGoals(@RequestParam long playerId, @RequestParam long goals) {
        Player player = playerService.getPlayerById(playerId).get();
        player.setGoals(goals);
        playerService.savePlayer(player);
    }

    @PostMapping(value = "/deletePlayer")
    public void deletePlayer(@RequestParam long playerId) {
        playerService.deletePlayer(playerId);
    }

    @GetMapping(value = "/getAllPlayers")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }
}
