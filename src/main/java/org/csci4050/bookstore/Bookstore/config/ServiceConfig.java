package org.csci4050.bookstore.Bookstore.config;

import org.csci4050.bookstore.Bookstore.dao.*;
import org.csci4050.bookstore.Bookstore.service.ClientService;
import org.csci4050.bookstore.Bookstore.service.CustomerService;
import org.csci4050.bookstore.Bookstore.service.VendorService;
import org.csci4050.bookstore.Bookstore.service.VerificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class ServiceConfig {

    @Bean
    public CustomerService customerService(final CustomerDao customerDao, final UserDao userDao) {
        return new CustomerService(customerDao, userDao);
    }

    @Bean
    public VendorService vendorService(final VendorDao vendorDao){
        return new VendorService(vendorDao);
    }

    @Bean
    public ClientService clientService(final ClientDao clientDao) {
        return new ClientService(clientDao);
    }

    @Bean
    public VerificationService verificationService(final JavaMailSender javaMailSender, final VerificationDao verificationDao) {
        return new VerificationService(javaMailSender, verificationDao);
    }
}
