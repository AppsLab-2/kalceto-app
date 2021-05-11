package com.backend.backendkalceto.matches;

import com.backend.backendkalceto.exception.NoAccessException;
import com.backend.backendkalceto.player.Player;

import java.security.Principal;
import java.util.Set;

public interface MatchesService {

    void saveMatch(Matches match);
    void generateMatch(long leagueId);
    void setPlayerScore(long matchId, long player1Score, long player2Score, Principal principal) throws NoAccessException;
}
