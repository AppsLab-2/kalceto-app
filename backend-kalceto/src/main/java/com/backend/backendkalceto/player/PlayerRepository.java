package com.backend.backendkalceto.player;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    Optional<Player> findByUsername(String username);
    Player findPlayerById(long playerId);
}
