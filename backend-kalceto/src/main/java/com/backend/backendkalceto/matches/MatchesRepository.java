package com.backend.backendkalceto.matches;

import com.backend.backendkalceto.player.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MatchesRepository extends CrudRepository<Matches, Long> {
}
