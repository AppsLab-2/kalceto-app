package com.backend.backendkalceto.league;

import com.backend.backendkalceto.matches.Matches;
import com.backend.backendkalceto.player.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LeagueRepository extends CrudRepository<League, Long> {
}
