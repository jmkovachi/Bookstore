package org.csci4050.bookstore.Bookstore.exceptions;

public class VerificationException extends Exception {

    public VerificationException(final String message, final String... params) {
        super(String.format(message, params));
    }
}
