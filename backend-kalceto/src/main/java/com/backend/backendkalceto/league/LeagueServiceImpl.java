package com.backend.backendkalceto.league;

import org.springframework.stereotype.Service;

@Service
public class LeagueServiceImpl implements LeagueService{

    LeagueRepository leagueRepository;

    public LeagueServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @Override
    public void saveLeague(League league) {
        leagueRepository.save(league);
    }
}
