package com.backend.backendkalceto.player;

import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService{

    PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }
}
