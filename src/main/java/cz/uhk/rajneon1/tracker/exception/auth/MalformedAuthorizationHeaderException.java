package cz.uhk.rajneon1.tracker.exception.auth;

import cz.uhk.rajneon1.tracker.exception.CustomException;

public class MalformedAuthorizationHeaderException extends CustomException {

    public MalformedAuthorizationHeaderException(String message) {
        super(message);
    }

}
