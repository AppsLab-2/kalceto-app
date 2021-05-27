package com.backend.backendkalceto.point;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PointServiceImpl implements PointService {
    PointRepository pointRepository;

    public PointServiceImpl(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }


    @Override
    public List<Point> sortByPoints(long leagueId) {
        List<Point> listOfPoints = pointRepository.findByLeagueId(leagueId);
        listOfPoints.sort(Comparator.comparing(Point::getPoints).reversed());
        return listOfPoints;
    }




}
