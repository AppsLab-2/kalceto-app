package com.backend.backendkalceto.league;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class LeagueController {
    LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @PostMapping(value = "/addLeague")
    public void addLeague(@RequestBody League league, Principal principal) {
        leagueService.createLeague(league, principal);
    }

    @PostMapping(value = "/assignPlayerToLeagues")
    public void assignPlayerToLeagues(@RequestParam long leagueId, @RequestParam long playerId) {
        leagueService.assignPlayerToLeagues(leagueId, playerId);
    }

    @PostMapping(value = "/deleteLeague")
    public void deleteLeague(@RequestParam long leagueId) {
        leagueService.deleteLeague(leagueId);
    }

    @GetMapping(value = "/getAllLeagues")
    public List<League> getAllLeagues() {
        return leagueService.getAllLeagues();
    }

    @PostMapping(value = "/changeLeagueName")
    public void changeLeagueName(@RequestParam long leagueId, @RequestParam String leagueName) {
        League league = leagueService.getLeagueById(leagueId).get();
        league.setLeagueName(leagueName);
        leagueService.saveLeague(league);
    }

}