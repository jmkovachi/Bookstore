package org.csci4050.bookstore.Bookstore.exceptions;

public class VerificationException extends Exception {

    public VerificationException() {
        super("Cannot send email verification");
    }
}
