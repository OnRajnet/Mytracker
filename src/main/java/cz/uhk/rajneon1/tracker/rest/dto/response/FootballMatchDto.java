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
    private double avgDistance;
    private double avgSpeed;
    private List<PerformanceDto> players;

    public int getFootballMatchId() {
        return footballMatchId;
    }

    public String getTrainer() {
        return trainer;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public int getTotalSteps() {
        return totalSteps;
    }

    public double getAvgSteps() {
        return avgSteps;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public double getAvgDistance() {
        return avgDistance;
    }

    public double getAvgSpeed() {
        return avgSpeed;
    }

    public List<PerformanceDto> getPlayers() {
        return players;
    }

    public void setFootballMatchId(int footballMatchId) {
        this.footballMatchId = footballMatchId;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setTotalSteps(int totalSteps) {
        this.totalSteps = totalSteps;
    }

    public void setAvgSteps(double avgSteps) {
        this.avgSteps = avgSteps;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void setAvgDistance(double avgDistance) {
        this.avgDistance = avgDistance;
    }

    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public void setPlayers(List<PerformanceDto> players) {
        this.players = players;
    }

    public FootballMatchDto(FootballMatch match) {
        footballMatchId = match.getId();
        trainer = match.getTrainer().getLogin();
        startTime = match.getStartTime();
        endTime = match.getEndTime();
        totalSteps = match.getTotalSteps();
        avgSteps = match.getAvgSteps();
        totalDistance = match.getTotalDistance();
        avgDistance = match.getAvgDistance();
        avgSpeed = match.getAvgSpeed();
        players = match.getPlayersPerformances().stream().map(PerformanceDto::new).collect(Collectors.toList());
    }
}
