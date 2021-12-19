package cz.uhk.rajneon1.tracker.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(PlayerPerformancePerMatchId.class)
public class PlayerPerformancePerMatch {

    @Id
    @ManyToOne
    @JoinColumn(name="football_match_id", referencedColumnName = "id")
    private FootballMatch footballMatch;

    @Id
    @ManyToOne
    @JoinColumn(name="player_login", referencedColumnName = "login")
    private Player player;

    private int steps;
    private double distance;
    private double maxSpeed;
    private double minSpeed;
    private double avgSpeed;

    public PlayerPerformancePerMatch() {
    }

    public PlayerPerformancePerMatch(Player player, int steps, double distance, double maxSpeed, double minSpeed, double avgSpeed) {
        this.player = player;
        this.steps = steps;
        this.distance = distance;
        this.maxSpeed = maxSpeed;
        this.minSpeed = minSpeed;
        this.avgSpeed = avgSpeed;
    }

    public FootballMatch getFootballMatch() {
        return footballMatch;
    }

    public void setFootballMatch(FootballMatch footballMatch) {
        this.footballMatch = footballMatch;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
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

class PlayerPerformancePerMatchId implements Serializable {
    private int footballMatch;
    private String player;

    public int getFootballMatch() {
        return footballMatch;
    }

    public void setFootballMatch(int footballMatch) {
        this.footballMatch = footballMatch;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerPerformancePerMatchId that = (PlayerPerformancePerMatchId) o;
        return footballMatch == that.footballMatch && Objects.equals(player, that.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(footballMatch, player);
    }
}