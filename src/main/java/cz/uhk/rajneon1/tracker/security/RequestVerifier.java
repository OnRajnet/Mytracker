package cz.uhk.rajneon1.tracker.security;

import cz.uhk.rajneon1.tracker.dao.UserRepository;
import cz.uhk.rajneon1.tracker.exception.auth.AuthorizationHeaderMissingException;
import cz.uhk.rajneon1.tracker.exception.auth.MalformedAuthorizationHeaderException;
import cz.uhk.rajneon1.tracker.exception.auth.UserVerificationException;
import cz.uhk.rajneon1.tracker.exception.resources.ForbiddenResourceException;
import cz.uhk.rajneon1.tracker.model.User;
import cz.uhk.rajneon1.tracker.model.UserRole;
import cz.uhk.rajneon1.tracker.utils.HeaderUtil;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
public class RequestVerifier {

    private UserRepository userRepository;
    private HeaderUtil headerUtil;
    private TokenHandler tokenHandler;

    public RequestVerifier(UserRepository userRepository, HeaderUtil headerUtil, TokenHandler tokenHandler) {
        this.userRepository = userRepository;
        this.headerUtil = headerUtil;
        this.tokenHandler = tokenHandler;
    }

    public User verifyRequest(HttpServletRequest request, UserRole... allowed)
            throws MalformedAuthorizationHeaderException, AuthorizationHeaderMissingException, UserVerificationException, ForbiddenResourceException {
        String token = headerUtil.getTokenFromAuthHeader(request);
        String login = tokenHandler.getUsernameFromToken(token);
        User user = userRepository.getOneByLogin(login);
        if (user == null) {
            throw new UserVerificationException("Unauthorized. User " + login + " not found");
        }
        if (Arrays.stream(allowed).noneMatch(it -> it.equals(user.getUserRole()))) {
            throw new ForbiddenResourceException("Forbidden. You cannot access this resource.");
        }
        return user;
    }
}
