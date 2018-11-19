package org.csci4050.bookstore.Bookstore.service;

import org.csci4050.bookstore.Bookstore.dao.VerificationDao;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Customer;
import org.csci4050.bookstore.Bookstore.model.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Optional;

public class VerificationService {

    private JavaMailSender javaMailSender;

    private VerificationDao verificationDao;

    private CustomerService customerService;

    @Autowired
    public VerificationService(final JavaMailSender javaMailSender, final VerificationDao verificationDao, final CustomerService customerService) {
        this.javaMailSender = javaMailSender;
        this.verificationDao = verificationDao;
        this.customerService = customerService;
    }

    public String sendVerificationEmail(final String username) throws ValidationException {
        final Optional<Customer> retrieveCustomer = customerService.getCustomer(username);

        if (!retrieveCustomer.isPresent()) {
            throw new ValidationException("Customer with username <%s> not found", username);
        }
        final Customer customer = retrieveCustomer.get();

        final Optional<Verification> preVerification = verificationDao.getVerification(username, customer.getEmail());
        if (preVerification.isPresent()) {
            javaMailSender.send(createMail(preVerification.get()));
            return customer.getAddress();
        } else {
            this.verificationDao.createVerification(username, customer.getEmail());
            final Optional<Verification> verification = verificationDao.getVerification(username, customer.getEmail());
            if (verification.isPresent()) {
                javaMailSender.send(createMail(verification.get()));
                return customer.getAddress();
            } else {
                throw new ValidationException("Creation of verification email for customer <%s> failed", username);
            }
        }
    }

    public boolean verifyCustomer(final String username, final int code) throws ValidationException {
        final Optional<Customer> retrieveCustomer = customerService.getCustomer(username);

        if (!retrieveCustomer.isPresent()) {
            throw new ValidationException("Customer with username <%s> not found", username);
        }

        final Customer customer = retrieveCustomer.get();

        final Optional<Verification> verification = verificationDao.getVerification(customer.getUsername(), customer.getEmail());

        if (verification.isPresent() && verification.get().getVerificationCode() == code) {
            customer.setVerified(true);
            customerService.updateCustomer(customer);
            return true;
        } else {
            return false;
        }
    }


    private SimpleMailMessage createMail(final Verification verification) {
        final SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(verification.getEmail());
        simpleMailMessage.setSubject("Your verification code for Bookstore.com");
        simpleMailMessage.setText(String.format("Hi %s, thanks for registering with Bookstore.com. On the verification screen," +
                " please enter this four digit code: %s", verification.getCUserName(), verification.getVerificationCode()));
        return simpleMailMessage;
    }

}
