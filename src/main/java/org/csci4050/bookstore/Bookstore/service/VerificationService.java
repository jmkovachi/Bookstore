package org.csci4050.bookstore.Bookstore.service;

import org.csci4050.bookstore.Bookstore.dao.VerificationDao;
import org.csci4050.bookstore.Bookstore.exceptions.VerificationException;
import org.csci4050.bookstore.Bookstore.model.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Optional;

public class VerificationService {

    private JavaMailSender javaMailSender;

    private VerificationDao verificationDao;

    @Autowired
    public VerificationService(final JavaMailSender javaMailSender, final VerificationDao verificationDao) {
        this.javaMailSender = javaMailSender;
        this.verificationDao = verificationDao;
    }

    public void sendVerificationEmail(final String cUsername, final String email) throws VerificationException {
        this.verificationDao.createVerification(cUsername, email);
        final Optional<Verification> verification = verificationDao.getVerification(cUsername, email);
        if (verification.isPresent()) {
            javaMailSender.send(createMail(verification.get()));
        } else {
            throw new VerificationException();
        }
    }


    private SimpleMailMessage createMail(final Verification verification) {
        final SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(verification.getEmail());
        simpleMailMessage.setSubject("Your verification code for Bookstore.com");
        simpleMailMessage.setText(String.format("Hi %s, thanks for registering with Bookstore.com. On the verification screen," +
                " please enter this four digit code: \n%s", verification.getCUserName(), verification.getVerificationCode()));
        return simpleMailMessage;
    }

}
