package cz.uhk.rajneon1.tracker.rest.dto.response;

import cz.uhk.rajneon1.tracker.model.UserRole;

import java.util.List;

public class PlayerDto {

    private String login;
    private UserRole role;
    private List<PerformanceDto> performances;

    public PlayerDto() {
    }

    public PlayerDto(String login, UserRole role, List<PerformanceDto> performances) {
        this.login = login;
        this.role = role;
        this.performances = performances;
    }

    public String getLogin() {
        return login;
    }

    public UserRole getRole() {
        return role;
    }

    public List<PerformanceDto> getPerformances() {
        return performances;
    }
}
