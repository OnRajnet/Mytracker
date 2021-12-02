package cz.uhk.rajneon1.tracker.rest.auth;

import cz.uhk.rajneon1.tracker.dao.UserRepository;
import cz.uhk.rajneon1.tracker.exception.auth.AuthorizationHeaderMissingException;
import cz.uhk.rajneon1.tracker.exception.auth.MalformedAuthorizationHeaderException;
import cz.uhk.rajneon1.tracker.exception.auth.UserVerificationException;
import cz.uhk.rajneon1.tracker.exception.resources.ForbiddenResourceException;
import cz.uhk.rajneon1.tracker.googlehttpclient.FitHttpClient;
import cz.uhk.rajneon1.tracker.helper.AuthLogin;
import cz.uhk.rajneon1.tracker.model.User;
import cz.uhk.rajneon1.tracker.model.UserRole;
import cz.uhk.rajneon1.tracker.security.GoogleOauthTokenHandler;
import cz.uhk.rajneon1.tracker.security.RequestVerifier;
import cz.uhk.rajneon1.tracker.security.ResourceVerifier;
import cz.uhk.rajneon1.tracker.security.TokenHandler;
import cz.uhk.rajneon1.tracker.utils.HeaderUtil;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
public class GoogleOauthTokenController {

    private UserRepository userRepository;
    private FitHttpClient fitHttpClient;
    private GoogleOauthTokenHandler googleOauthTokenHandler;
    private RequestVerifier requestVerifier;
    private ResourceVerifier resourceVerifier;
    private Environment environment;
    private TokenHandler tokenHandler;
    private HeaderUtil headerUtil;
    private AuthLogin authLogin;

    public GoogleOauthTokenController(UserRepository userRepository, FitHttpClient fitHttpClient,
                                      GoogleOauthTokenHandler googleOauthTokenHandler, RequestVerifier requestVerifier,
                                      ResourceVerifier resourceVerifier, Environment environment,
                                      TokenHandler tokenHandler, HeaderUtil headerUtil, AuthLogin authLogin) {
        this.userRepository = userRepository;
        this.fitHttpClient = fitHttpClient;
        this.googleOauthTokenHandler = googleOauthTokenHandler;
        this.requestVerifier = requestVerifier;
        this.resourceVerifier = resourceVerifier;
        this.environment = environment;
        this.tokenHandler = tokenHandler;
        this.headerUtil = headerUtil;
        this.authLogin = authLogin;
    }

    @GetMapping("/api/auth/handleGoogleAuthToken")
    public void saveGoogleOAuthToken(@RequestParam("state") String state, @RequestParam("code") String googleToken) throws IOException,
            InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException,
            URISyntaxException {

        String loginFromJwtToken = tokenHandler.getUsernameFromToken(authLogin.jwtTokenSpliter(state));

        if (!authLogin.loginSpliter(state).equals(loginFromJwtToken)) {
            throw new IllegalStateException("Cannot change Google token of another user.");
        }
        googleOauthTokenHandler.saveRefreshToken(authLogin.loginSpliter(state), fitHttpClient.retrieveRefreshToken(googleToken));
    }

    @GetMapping("/api/player/{login}/consent")
    public String getPlayerConsent(@PathVariable("login") String login, HttpServletRequest request, HttpServletResponse response) throws ForbiddenResourceException,
            UserVerificationException, MalformedAuthorizationHeaderException, AuthorizationHeaderMissingException, IOException {
        User requestingUser = requestVerifier.verifyRequest(request, UserRole.PLAYER);
        resourceVerifier.verifyResource(requestingUser, login);
        String protocol = environment.getProperty("server.ssl.key-store") != null ? "https" : "http";
        int port = Integer.parseInt(environment.getProperty("server.port"));
        String token = headerUtil.getTokenFromAuthHeader(request);
        return fitHttpClient.buildUserConsentRedirect(protocol + "://localhost:" + port, login, token);
    }

}