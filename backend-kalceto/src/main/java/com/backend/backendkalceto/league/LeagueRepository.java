package com.backend.backendkalceto.league;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LeagueRepository extends CrudRepository<League, Long> {
    List<League> findAll();
}
