package com.backend.backendkalceto.matches;

import com.backend.backendkalceto.league.LeagueRepository;
import com.backend.backendkalceto.player.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MatchesServiceImpl implements MatchesService {
    MatchesRepository matchRepository;
    LeagueRepository leagueRepository;

    public MatchesServiceImpl(MatchesRepository matchRepository, LeagueRepository leagueRepository) {
        this.matchRepository = matchRepository;
        this.leagueRepository = leagueRepository;
    }

    @Override
    public void saveMatch(Matches match) {
        matchRepository.save(match);
    }

    @Override
    public void generateMatch(long leagueId) {
        int numberOfPlayersInLeague = leagueRepository.findById(leagueId).get().getPlayers().size();
        Set<Player> set = leagueRepository.findById(leagueId).get().getPlayers();
        List<Player> players = new ArrayList<>();
        players.addAll(set);

        for(int i=0; i<numberOfPlayersInLeague; i++){
            int one = 1;
            for(int j=one; j<players.size()-i; j++){
                Matches matches = new Matches();
                matches.setPlayer1Score(0);
                matches.setPlayer2Score(0);
                matches.setLeagueId(leagueId);
                matches.setPlayer1Id(players.get(i).getId());
                matches.setPlayer2Id(players.get(i + j).getId());
                saveMatch(matches);
            }
        }
    }

    @Override
    public void setPlayerScore(long matchId, long player1Score, long player2Score) {
        Matches matches = matchRepository.findById(matchId).get();
        matches.setPlayer1Score(player1Score);
        matches.setPlayer2Score(player2Score);
        saveMatch(matches);

    }
}
