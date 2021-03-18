package com.backend.backendkalceto.player;

import java.util.Optional;

public interface PlayerService {

    void savePlayer(Player player);
    Optional<Player> getPlayerById(long id);

}
