package org.csci4050.bookstore.Bookstore.service;

import org.csci4050.bookstore.Bookstore.dao.CustomerDao;
import org.csci4050.bookstore.Bookstore.dao.UserDao;
import org.csci4050.bookstore.Bookstore.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CustomerService extends UserService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerService(final CustomerDao customerDao, final UserDao userDao) {
        super(userDao);
        this.customerDao = customerDao;
    }

    public Customer registerCustomer(final Customer customer) throws Exception {
        customerDao.createCustomer(customer);
        final Optional<Customer> retrieveCustomer = customerDao.getCustomer(customer.getUsername());
        if (retrieveCustomer.isPresent() && retrieveCustomer.get().equals(customer)) {
            return retrieveCustomer.get();
        } else {
            throw new Exception();
        }
    }

    public Optional<Customer> getCustomer(final String username) {
        return customerDao.getCustomer(username);
    }
}
