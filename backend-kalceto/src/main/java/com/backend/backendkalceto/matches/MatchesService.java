package com.backend.backendkalceto.matches;

import com.backend.backendkalceto.exception.GenericException;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface MatchesService {

    void saveMatch(Matches match);
    void generateMatch(long leagueId);
    void setPlayerScore(long matchId, long player1Score, long player2Score, Principal principal) throws GenericException;
    List<Matches> getMatchesFromLeague(long leagueId);
}
