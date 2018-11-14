package org.csci4050.bookstore.Bookstore.config;

import org.csci4050.bookstore.Bookstore.dao.CustomerDao;
import org.csci4050.bookstore.Bookstore.dao.UserDao;
import org.csci4050.bookstore.Bookstore.dao.VendorDao;
import org.csci4050.bookstore.Bookstore.service.CustomerService;
import org.csci4050.bookstore.Bookstore.service.VendorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
