package com.backend.backendkalceto.player;

import com.backend.backendkalceto.point.Point;
import com.backend.backendkalceto.point.PointService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PlayerServiceImpl implements PlayerService {

    PlayerRepository playerRepository;
    PasswordEncoder passwordEncoder;
    PointService pointService;

    public PlayerServiceImpl(PlayerRepository playerRepository, PasswordEncoder passwordEncoder, PointService pointService) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
        this.pointService = pointService;
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

    @Override
    public void getSignedInPlayer() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
        } else {
            String username = principal.toString();
        }
    }

    @Override
    public boolean ifPlayerExistsByUsername(String username) {
        return getPLayerByUsername(username).isPresent();
    }

    @Override
    public List<Player> getPlayersFromLeague(long leagueId) {
        List<Player> players = new ArrayList<>();
        List<Point> points = pointService.sortByPoints(leagueId);
        for(int i = 0;i<points.size();i++){
            players.add(playerRepository.findPlayerById(points.get(i).getPlayerId()));
        }
        return players;
    }


}
