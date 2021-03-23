package com.backend.backendkalceto.league;

import com.backend.backendkalceto.player.Player;
import com.backend.backendkalceto.player.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LeagueController {
    LeagueService leagueService;
    PlayerService playerService;

    public LeagueController(LeagueService leagueService, PlayerService playerService) {
        this.leagueService = leagueService;
        this.playerService = playerService;
    }

    @PostMapping(value = "/addLeague")
    public void request(@RequestBody League league) {
        leagueService.saveLeague(league);
    }

    @PostMapping(value = "/assignPlayerToLeagues")
    public void request(@RequestParam long leagueId, @RequestParam long playerId) {
        League league = leagueService.getLeagueById(leagueId).get();
        Player player = playerService.getPlayerById(playerId).get();
        player.getLeagues().add(league);
        league.getPlayers().add(player);
        leagueService.saveLeague(league);
    }

    @PostMapping(value = "/deleteLeague")
    public void request(@RequestParam long leagueId) {
        leagueService.deleteLeague(leagueId);
    }

    @GetMapping(value = "/getAllLeagues")
    public void request() {
        leagueService.getAllLeagues();
        System.out.println("test");
    }
}