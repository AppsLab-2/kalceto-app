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

    @PostMapping(value = "/generateMatches")
    public void generateMatches(@RequestParam long leagueId) {
        matchService.generateMatch(leagueId);
    }

    @PostMapping(value = "/setMatchScore")
    public void setMatchScore(@RequestParam long matchId,@RequestParam long player1Score,@RequestParam long player2Score) {
        matchService.setPlayerScore(matchId, player1Score, player2Score);
    }
}
