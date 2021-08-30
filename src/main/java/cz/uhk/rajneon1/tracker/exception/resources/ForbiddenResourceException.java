package cz.uhk.rajneon1.tracker.exception.resources;

import cz.uhk.rajneon1.tracker.exception.CustomException;

public class ForbiddenResourceException extends CustomException {

    public ForbiddenResourceException(String message) {
        super(message);
    }

}
