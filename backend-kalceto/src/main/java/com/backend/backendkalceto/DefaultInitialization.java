package com.backend.backendkalceto;

import com.backend.backendkalceto.player.Player;
import com.backend.backendkalceto.player.PlayerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultInitialization implements CommandLineRunner {

    private final PlayerService playerService;
    private final PasswordEncoder passwordEncoder;

    public DefaultInitialization(PlayerService playerService, PasswordEncoder passwordEncoder) {
        this.playerService = playerService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (playerService.getPLayerByUsername("admin").isEmpty()==true){
            this.createAndPersistPlayer("admin", "admin");
        }
    }

    private void createAndPersistPlayer(String username, String password) {
            String encodedPassword = this.passwordEncoder.encode(password);
            Player player = new Player(username, encodedPassword);
            this.playerService.savePlayer(player);
    }

}