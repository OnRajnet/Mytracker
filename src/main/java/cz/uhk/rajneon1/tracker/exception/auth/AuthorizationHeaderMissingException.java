package cz.uhk.rajneon1.tracker.exception.auth;

import cz.uhk.rajneon1.tracker.exception.CustomException;

public class AuthorizationHeaderMissingException extends CustomException {

    public AuthorizationHeaderMissingException(String message) {
        super(message);
    }

}
