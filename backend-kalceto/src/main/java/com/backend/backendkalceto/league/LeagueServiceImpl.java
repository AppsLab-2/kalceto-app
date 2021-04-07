package com.backend.backendkalceto.league;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<League> getLeagueById(long id) {
        return leagueRepository.findById(id);
    }

    @Override
    public void deleteLeague(long leagueId) {
        leagueRepository.deleteById(leagueId);
    }

    @Override
    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }
}
