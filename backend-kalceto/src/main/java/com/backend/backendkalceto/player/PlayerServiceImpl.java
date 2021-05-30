package com.backend.backendkalceto.player;

import com.backend.backendkalceto.dto.PlayerDto;
import com.backend.backendkalceto.point.Point;
import com.backend.backendkalceto.point.PointService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public List<PlayerDto> getPlayersFromLeague(long leagueId) {
        List<Player> players = new ArrayList<>();
        List<Point> points = pointService.sortByPoints(leagueId);
        List<PlayerDto> playerDtoList = new ArrayList<>();
        for(int i = 0;i<points.size();i++) {
            players.add(playerRepository.findPlayerById(points.get(i).getPlayerId()));
            PlayerDto playerDto = new PlayerDto(players.get(i).getId(), players.get(i).getUsername(), players.get(i).getPassword(), players.get(i).getWins(), players.get(i).getLosses(), players.get(i).getDraws(), players.get(i).getGoals(), points.get(i).getPoints());
            playerDtoList.add(playerDto);
        }
//        for(int i = 0;i<players.size();i++){
//            PlayerDto playerDto = new PlayerDto(players.get(i).getId(), players.get(i).getUsername(), players.get(i).getPassword(), players.get(i).getWins(), players.get(i).getLosses(), players.get(i).getDraws(), players.get(i).getGoals());
//            playerDtoList.add(playerDto);
//        }
        return playerDtoList;
    }

}
