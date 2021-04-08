package com.backend.backendkalceto.league;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface LeagueService {
    void saveLeague(League league);
    Optional<League> getLeagueById(long id);
    void deleteLeague(long leagueId);
    List<League> getAllLeagues();
    void assignPlayerToLeagues(long leagueId, long playerId);

}
