package com.backend.backendkalceto.league;

<<<<<<< HEAD
=======
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

>>>>>>> b331acf0e5f6b98b683a925443e4add21b285811
import java.util.List;
import java.util.Optional;

public interface LeagueService {
    League saveLeague(League league);
    Optional<League> getLeagueById(long id);
    void deleteLeague(long leagueId);
    List<League> getAllLeagues();
    void assignPlayerToLeagues(long leagueId, long playerId);

}
