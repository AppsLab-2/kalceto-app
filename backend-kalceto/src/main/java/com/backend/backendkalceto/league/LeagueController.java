package com.backend.backendkalceto.league;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeagueController {
    LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @PostMapping(value = "/addLeague")
<<<<<<< HEAD
    public League request(@RequestBody League league) {
        return leagueService.saveLeague(league);
=======
    public void addLeague(@RequestBody League league) {
        leagueService.saveLeague(league);
>>>>>>> b331acf0e5f6b98b683a925443e4add21b285811
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