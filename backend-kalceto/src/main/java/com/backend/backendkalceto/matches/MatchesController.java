package com.backend.backendkalceto.matches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MatchesController {
    MatchesService matchService;

    @Autowired
    public MatchesController(MatchesService matchService) {
        this.matchService = matchService;
    }

    @PostMapping(value = "/addMatch")
    public void addMatch(@RequestBody Matches match){
        matchService.saveMatch(match);
    }
}
