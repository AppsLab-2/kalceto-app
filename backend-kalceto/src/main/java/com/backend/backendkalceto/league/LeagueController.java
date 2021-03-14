package com.backend.backendkalceto.league;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeagueController {
    LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @PostMapping(value = "/requestLeague")
    public void request(@RequestBody League league) {
        leagueService.saveLeague(league);
    }
}