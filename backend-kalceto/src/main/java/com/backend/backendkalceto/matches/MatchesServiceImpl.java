package com.backend.backendkalceto.matches;

import com.backend.backendkalceto.exception.GenericException;
import com.backend.backendkalceto.league.League;
import com.backend.backendkalceto.league.LeagueRepository;
import com.backend.backendkalceto.player.Player;
import com.backend.backendkalceto.player.PlayerService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MatchesServiceImpl implements MatchesService {
    MatchesRepository matchRepository;
    LeagueRepository leagueRepository;
    PlayerService playerService;

    public MatchesServiceImpl(MatchesRepository matchRepository, LeagueRepository leagueRepository, PlayerService playerService) {
        this.matchRepository = matchRepository;
        this.leagueRepository = leagueRepository;
        this.playerService = playerService;
    }

    @Override
    public void saveMatch(Matches match) {
        matchRepository.save(match);
    }

    @Override
    public void generateMatch(long leagueId) {
        Set<Player> set = leagueRepository.findById(leagueId).get().getPlayers();
        List<Player> players = new ArrayList<>();
        players.addAll(set);

        for(int i=0; i<players.size(); i++){
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
    public void setPlayerScore(long matchId, long player1Score, long player2Score, Principal principal) throws GenericException {
        Matches matches = matchRepository.findById(matchId).get();
        League league = leagueRepository.findById(matches.getLeagueId()).get();


        if (playerService.getPLayerByUsername(principal.getName()).get().getId()==league.getAdminId()){
            matches.setPlayer1Score(player1Score);
            matches.setPlayer2Score(player2Score);
            saveMatch(matches);
        }
        else{
            throw new GenericException("User is not the admin of this league");
        }
    }

    @Override
    public List<Matches> getMatchesFromLeague(long leagueId) {
        List<Matches> matches = matchRepository.findAllByLeagueId(leagueId);
        return matches;
    }
}
