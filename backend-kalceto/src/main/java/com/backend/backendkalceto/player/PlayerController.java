package com.backend.backendkalceto.player;

import com.backend.backendkalceto.exception.GenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
public class PlayerController {
    PlayerService playerService;
    PasswordEncoder passwordEncoder;

    @Autowired
    public PlayerController(PlayerService playerService, PasswordEncoder passwordEncoder) {
        this.playerService = playerService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(value = "/register")
    public void register(@RequestBody Player player) throws GenericException {
        if(playerService.ifPlayerExistsByUsername(player.getUsername())==false){
            player.setPassword(passwordEncoder.encode(player.getPassword()));
            playerService.savePlayer(player);
        }
        else
            throw new GenericException("Username is already in use!");

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
