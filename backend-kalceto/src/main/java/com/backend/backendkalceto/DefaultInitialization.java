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
        this.createAndPersistPlayer("martin", "Martin", "Strbanik", "password", 69, 98, 54, 420);
    }

    private void createAndPersistPlayer(String username, String name, String surname, String password, long wins, long losses, long draws, long goals) {
            String encodedPassword = this.passwordEncoder.encode(password);
            Player player = new Player(username, name, surname, encodedPassword, wins, losses, draws, goals);
            this.playerService.savePlayer(player);
    }

}