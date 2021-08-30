package cz.uhk.rajneon1.tracker.security;

import cz.uhk.rajneon1.tracker.exception.resources.ForbiddenResourceException;
import cz.uhk.rajneon1.tracker.model.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ResourceVerifier {

    public void verifyResource(User requestOwner, String... allowed) throws ForbiddenResourceException {
        if (Arrays.stream(allowed).noneMatch( it -> it.equals(requestOwner.getLogin()))) {
            throw new ForbiddenResourceException("Forbidden. You cannot access this resource.");
        }
    }

}
