package com.backend.backendkalceto.league;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface LeagueService {
    void saveLeague(League league);
    Optional<League> getLeagueById(long id);
    void deleteLeague(long leagueId);
    List<League> getAllLeagues();

}
