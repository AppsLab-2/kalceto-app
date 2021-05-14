package com.backend.backendkalceto.league;

import com.backend.backendkalceto.exception.GenericException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface LeagueService {
    League saveLeague(League league);
    Optional<League> getLeagueById(long id);
    void deleteLeague(long leagueId, Principal principal) throws GenericException;
    List<League> getAllLeagues();
    void assignPlayerToLeagues(long leagueId, long playerId);
    void createLeague(League league, Principal principal);
    void changeLeagueName(long leagueId, String leagueName, Principal principal) throws GenericException;
}
