package cz.uhk.rajneon1.tracker.exception.resources;

import cz.uhk.rajneon1.tracker.exception.CustomException;

public class BadRequestException extends CustomException {

    public BadRequestException(String message) {
        super(message);
    }

}
