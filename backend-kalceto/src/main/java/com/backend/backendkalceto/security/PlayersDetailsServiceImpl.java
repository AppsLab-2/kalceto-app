package com.backend.backendkalceto.security;


import com.backend.backendkalceto.player.PlayerService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PlayersDetailsServiceImpl implements UserDetailsService {

    private final PlayerService playerService;

    public PlayersDetailsServiceImpl(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.playerService.getPLayerByUsername(username)
                .map(PlayersDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

}