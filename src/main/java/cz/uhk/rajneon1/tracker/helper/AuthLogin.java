package cz.uhk.rajneon1.tracker.helper;

import org.springframework.stereotype.Component;

@Component
public class AuthLogin {

    String login;
    String jwtToken;

    public String loginSpliter(String state){
        var parts = state.split(";");
        login = parts[0];
        return login;
    }

    public String jwtTokenSpliter(String state){
        var parts = state.split(";");
        jwtToken = parts[1];
        return jwtToken;
    }

    public String getLogin() {
        return login;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
