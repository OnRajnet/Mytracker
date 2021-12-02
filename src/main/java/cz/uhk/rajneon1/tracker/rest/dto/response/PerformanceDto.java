package cz.uhk.rajneon1.tracker.rest.dto.response;

import cz.uhk.rajneon1.tracker.model.PlayerPerformancePerMatch;

public class PerformanceDto {

    private int footballMatchId;
    private String player;
    private int steps;
    private double distance;
    private double maxSpeed;
    private double minSpeed;
    private double avgSpeed;

    public PerformanceDto() {
    }

    public PerformanceDto(PlayerPerformancePerMatch performance) {
        footballMatchId = performance.getFootballMatch().getId();
        player = performance.getPlayer().getLogin();
        steps = performance.getSteps();
        distance = performance.getDistance();
        maxSpeed = performance.getMaxSpeed();
        minSpeed = performance.getMinSpeed();
        avgSpeed = performance.getAvgSpeed();
    }

    public int getFootballMatchId() {
        return footballMatchId;
    }

    public void setFootballMatchId(int footballMatchId) {
        this.footballMatchId = footballMatchId;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(double minSpeed) {
        this.minSpeed = minSpeed;
    }

    public double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }
}
