package com.backend.backendkalceto.league;

import java.util.List;
import java.util.Optional;

public interface LeagueService {
    League saveLeague(League league);
    Optional<League> getLeagueById(long id);
    void deleteLeague(long leagueId);
    List<League> getAllLeagues();

}
