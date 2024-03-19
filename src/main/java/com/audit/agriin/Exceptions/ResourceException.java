package com.audit.agriin.Exceptions;

import com.audit.agriin.Domains.Entities.NonCorporate.User;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The parent for all exceptions, associated with resources, such as {@link User} etc.
 *
 * @author NOUHI Sidati
 * @version 1.0
 */
@RestControllerAdvice
public class ResourceException extends RuntimeException {
    public ResourceException() {
    }

    public ResourceException(String message) {
        super(message);
    }
}
