package com.backend.backendkalceto.player;

import org.springframework.stereotype.Component;

import java.util.Optional;

public interface PlayerService {

    void savePlayer(Player player);
    Optional<Player> getPlayerById(long id);
    void deletePlayer(long playerId);

}
