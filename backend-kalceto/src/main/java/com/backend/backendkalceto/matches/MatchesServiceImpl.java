package com.backend.backendkalceto.matches;

import org.springframework.stereotype.Service;

@Service
public class MatchesServiceImpl implements MatchesService {
    MatchesRepository matchRepository;

    public MatchesServiceImpl(MatchesRepository matchRepository) {
        this.matchRepository = matchRepository;
    }


    @Override
    public void saveMatch(Matches match) {
        matchRepository.save(match);
    }
}
