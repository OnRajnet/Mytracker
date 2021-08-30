package cz.uhk.rajneon1.tracker.model;

import cz.uhk.rajneon1.tracker.model.FootballMatch;

import javax.persistence.*;

@Entity
public class PlayerPerformancePerMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private FootballMatch footballMatch;
    @ManyToOne
    private cz.uhk.rajneon1.tracker.model.Player player;
    private int steps;
    private double distance;
    private double maxSpeed;
    private double minSpeed;
    private double avgSpeed;

    public PlayerPerformancePerMatch() {
    }

    public PlayerPerformancePerMatch(cz.uhk.rajneon1.tracker.model.Player player, int steps, double distance, double maxSpeed, double minSpeed, double avgSpeed) {
        this.player = player;
        this.steps = steps;
        this.distance = distance;
        this.maxSpeed = maxSpeed;
        this.minSpeed = minSpeed;
        this.avgSpeed = avgSpeed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FootballMatch getFootballMatch() {
        return footballMatch;
    }

    public void setFootballMatch(FootballMatch footballMatch) {
        this.footballMatch = footballMatch;
    }

    public cz.uhk.rajneon1.tracker.model.Player getPlayer() {
        return player;
    }

    public void setPlayer(cz.uhk.rajneon1.tracker.model.Player player) {
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
