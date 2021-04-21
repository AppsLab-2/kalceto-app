package com.backend.backendkalceto.league;

import com.backend.backendkalceto.player.Player;
import com.backend.backendkalceto.player.PlayerService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueServiceImpl implements LeagueService{

    LeagueRepository leagueRepository;
    PlayerService playerService;

    public LeagueServiceImpl(LeagueRepository leagueRepository, PlayerService playerService) {
        this.leagueRepository = leagueRepository;
        this.playerService = playerService;
    }

    @Override
    public void saveLeague(League league) {
        leagueRepository.save(league);
    }

    @Override
    public Optional<League> getLeagueById(long id) {
        return leagueRepository.findById(id);
    }

    @Override
    public void deleteLeague(long leagueId) {
        leagueRepository.deleteById(leagueId);
    }

    @Override
    public List<League> getAllLeagues() {
        return (List<League>) leagueRepository.findAll();
    }

    @Override
    public void assignPlayerToLeagues(long leagueId, long playerId) {
        League league = getLeagueById(leagueId).get();
        Player player = playerService.getPlayerById(playerId).get();
        player.getLeagues().add(league);
        league.getPlayers().add(player);
        saveLeague(league);
    }
}
