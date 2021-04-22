package com.backend.backendkalceto.matches;

import org.springframework.stereotype.Service;

@Service
public class MatchesServiceImpl implements MatchesService {
    MatchesRepository matchRepository;

    public MatchesServiceImpl(MatchesRepository matchRepository) {
        this.matchRepository = matchRepository;
    }


    @Override
    public void saveMatch(Matches match) {
        matchRepository.save(match);
    }

    @Override
    public void generateMatch(long leagueId, long player1Id, long player2Id) {
        Matches matches = new Matches();
        matches.setPlayer1Score(0);
        matches.setPlayer2Score(0);
        matches.setLeagueId(leagueId);
        matches.setPlayer1Id(player1Id);
        matches.setPlayer2Id(player2Id);
        saveMatch(matches);
    }

    @Override
    public void setPlayerScore(long matchId, long player1Score, long player2Score) {
        Matches matches = matchRepository.findById(matchId).get();
        matches.setPlayer1Score(player1Score);
        matches.setPlayer2Score(player2Score);
        saveMatch(matches);

    }
}
