package com.backend.backendkalceto.player;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    void savePlayer(Player player);
    Optional<Player> getPlayerById(long id);
    void deletePlayer(long playerId);
    List<Player> getAllPlayers();
    Optional<Player> getPLayerByUsername(String username);
    void getSignedInPlayer();
    boolean ifPlayerExistsByUsername(String username);

}
