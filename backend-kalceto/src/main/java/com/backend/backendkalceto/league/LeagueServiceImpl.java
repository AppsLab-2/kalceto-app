package com.backend.backendkalceto.league;

import com.backend.backendkalceto.exception.GenericException;
import com.backend.backendkalceto.matches.MatchesService;
import com.backend.backendkalceto.player.Player;
import com.backend.backendkalceto.player.PlayerService;

import com.backend.backendkalceto.point.Point;
import com.backend.backendkalceto.point.PointRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LeagueServiceImpl implements LeagueService{

    LeagueRepository leagueRepository;
    PlayerService playerService;
    MatchesService matchesService;
    PointRepository pointRepository;

    public LeagueServiceImpl(LeagueRepository leagueRepository, PlayerService playerService, MatchesService matchesService, PointRepository pointRepository) {
        this.leagueRepository = leagueRepository;
        this.playerService = playerService;
        this.matchesService = matchesService;
        this.pointRepository = pointRepository;
    }

    @Override
    public League saveLeague(League league) {
        leagueRepository.save(league);
        return league;
    }

    @Override
    public Optional<League> getLeagueById(long id) {
        return leagueRepository.findById(id);
    }

    @Override
    public void deleteLeague(long leagueId, Principal principal) throws GenericException {
        if (playerService.getPLayerByUsername(principal.getName()).get().getId()==leagueRepository.findById(leagueId).get().getAdminId()){
            leagueRepository.deleteById(leagueId);
        }
        else{
            throw new GenericException("User is not the admin of this league");
        }
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

        Point point = new Point();
        point.setLeagueId(leagueId);
        point.setPlayerId(playerId);
        pointRepository.save(point);

        saveLeague(league);
    }

    @Override
    public void createLeague(League league, Principal principal) {
        league.setAdminId(playerService.getPLayerByUsername(principal.getName()).get().getId());
        leagueRepository.save(league);
    }

    @Override
    public void changeLeagueName(long leagueId, String leagueName, Principal principal) throws GenericException {

        if (playerService.getPLayerByUsername(principal.getName()).get().getId()==leagueRepository.findById(leagueId).get().getAdminId()){
            League league = getLeagueById(leagueId).get();
            league.setLeagueName(leagueName);
            saveLeague(league);
        }
        else{
            throw new GenericException("User is not the admin of this league");
        }
    }

    @Override
    public Set<Player> getPlayersFromLeague(long leagueId) {
        League league  = leagueRepository.findById(leagueId).get();
        return league.players;
    }
}
