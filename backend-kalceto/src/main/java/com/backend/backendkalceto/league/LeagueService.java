package com.backend.backendkalceto.league;

import java.util.Optional;

public interface LeagueService {
    void saveLeague(League league);
    Optional<League> getLeagueById(long id);
}
