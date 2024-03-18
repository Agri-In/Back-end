package com.audit.agriin.Exceptions;

/**
 * This class is used when an attempt to find an entity has thrown an exception.
 *
 * @author NOUHI Sidati
 * @version 1.0
 */
public class ResourceNotFoundException extends ResourceException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
