package com.backend.backendkalceto.league;

import com.backend.backendkalceto.player.Player;
import com.backend.backendkalceto.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LeagueController {
    LeagueService leagueService;
    PlayerService playerService;

    @Autowired
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
    public List<League> request() {
        return leagueService.getAllLeagues();
    }

    @PostMapping(value = "/changeLeagueName")
    public void request(@RequestParam long leagueId, @RequestParam String leagueName) {
        League league = leagueService.getLeagueById(leagueId).get();
        league.setLeagueName(leagueName);
        leagueService.saveLeague(league);
    }

}