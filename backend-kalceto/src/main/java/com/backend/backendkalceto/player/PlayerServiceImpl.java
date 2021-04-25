package com.backend.backendkalceto.player;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService{

    PlayerRepository playerRepository;
    PasswordEncoder passwordEncoder;

    public PlayerServiceImpl(PlayerRepository playerRepository, PasswordEncoder passwordEncoder) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Optional<Player> getPlayerById(long id) {
        return playerRepository.findById(id);
    }

    @Override
    public void deletePlayer(long playerId) {
        playerRepository.deleteById(playerId);
    }

    @Override
    public List<Player> getAllPlayers() {
        return (List<Player>) playerRepository.findAll();
    }

    @Override
    public Optional<Player> getPLayerByUsername(String username) {
        return playerRepository.findByUsername(username);
    }


}
