package com.backend.backendkalceto.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(value = "/addPlayer")
    public void request(@RequestBody Player player){
        playerService.savePlayer(player);
    }

    @PostMapping(value = "/setPlayerGoals")
    public void request(@RequestParam long playerId, @RequestParam long goals) {
        Player player = playerService.getPlayerById(playerId).get();
        player.setGoals(goals);
        playerService.savePlayer(player);
    }

    @PostMapping(value = "/deletePlayer")
    public void request(@RequestParam long playerId) {
        playerService.deletePlayer(playerId);
    }
}
