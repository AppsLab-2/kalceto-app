package com.backend.backendkalceto.league;

import com.backend.backendkalceto.player.Player;
import com.backend.backendkalceto.player.PlayerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LeagueController {
    LeagueService leagueService;
    PlayerService playerService;

    public LeagueController(LeagueService leagueService, PlayerService playerService) {
        this.leagueService = leagueService;
        this.playerService = playerService;
    }

    @PostMapping(value = "/requestLeague")
    public void request(@RequestBody League league) {
        leagueService.saveLeague(league);
    }

    @PostMapping(value = "/addPlayer")
    public void request(@RequestParam long leagueId, @RequestParam long playerId) {
        League league = leagueService.getLeagueById(leagueId).get();
        Player player = playerService.getPlayerById(playerId).get();
        player.getLeagues().add(league);
        league.getPlayers().add(player);
        leagueService.saveLeague(league);
    }

}