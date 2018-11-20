package org.csci4050.bookstore.Bookstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ValidationException extends Exception {

    public ValidationException(final String message, final String... params) {
        super(String.format(message, params));
    }
}
