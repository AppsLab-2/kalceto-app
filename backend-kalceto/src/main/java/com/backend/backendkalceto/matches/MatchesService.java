package com.backend.backendkalceto.matches;

public interface MatchesService {

    void saveMatch(Matches match);
    void generateMatch(long leagueId, long player1Id, long player2Id);
    void setPlayerScore(long matchId, long player1Score, long player2Score);
}
