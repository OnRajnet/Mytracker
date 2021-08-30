package cz.uhk.rajneon1.tracker.rest.dto.response;

import cz.uhk.rajneon1.tracker.model.FootballMatch;

import java.util.List;
import java.util.stream.Collectors;

public class FootballMatchDto {

    private int footballMatchId;
    private String trainer;
    private long startTime;
    private long endTime;
    private int totalSteps;
    private double avgSteps;
    private double totalDistance;
    private double avgdistance;
    private double avgSpeed;
    private List<PerformanceDto> players;


    public FootballMatchDto(FootballMatch match) {
        footballMatchId = match.getId();
        trainer = match.getTrainer().getLogin();
        startTime = match.getStartTime();
        endTime = match.getEndTime();
        totalSteps = match.getTotalSteps();
        avgSteps = match.getAvgSteps();
        totalDistance = match.getTotalDistance();
        avgdistance = match.getAvgDistance();
        avgSpeed = match.getAvgSpeed();
        players = match.getPlayersPerformances().stream().map(PerformanceDto::new).collect(Collectors.toList());
    }
}
