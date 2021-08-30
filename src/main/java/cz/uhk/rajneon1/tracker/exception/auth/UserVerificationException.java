package cz.uhk.rajneon1.tracker.exception.auth;

import cz.uhk.rajneon1.tracker.exception.CustomException;

public class UserVerificationException extends CustomException {

    public UserVerificationException(String message) {
        super(message);
    }

}
