package com.backend.backendkalceto.league;

<<<<<<< HEAD
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


=======

>>>>>>> a416a410de8eb4f65f931b51d0d6bf8a87c4da90
import java.util.List;
import java.util.Optional;

public interface LeagueService {
    League saveLeague(League league);
    Optional<League> getLeagueById(long id);
    void deleteLeague(long leagueId);
    List<League> getAllLeagues();
    void assignPlayerToLeagues(long leagueId, long playerId);

}
