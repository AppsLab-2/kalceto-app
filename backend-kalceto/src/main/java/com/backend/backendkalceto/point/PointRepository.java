package com.backend.backendkalceto.point;

import com.backend.backendkalceto.player.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PointRepository extends CrudRepository<Point, Long> {
    List<Point> findByLeagueId(long leagueId);
}
