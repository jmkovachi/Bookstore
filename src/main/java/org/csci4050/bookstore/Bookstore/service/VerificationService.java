package org.csci4050.bookstore.Bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

public class VerificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendVerificationEmail(final String username, final String address) {
        
    }

}
