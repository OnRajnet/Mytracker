package cz.uhk.rajneon1.tracker.exception.resources;

import cz.uhk.rajneon1.tracker.exception.CustomException;

public class ResourceNotFoundException extends CustomException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
