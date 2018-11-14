package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.mappers.CustomerMapper;
import org.csci4050.bookstore.Bookstore.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class CustomerDao extends UserDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createCustomer(final Customer customer) {
        this.createUser(customer);
        this.jdbcTemplate.update("insert into customer(c_username,first_name,address,minit,last_name,birth_date,verified,newsletter) " +
                "values(?,?,?,?,?,?,?,?);", customer.getUsername(), customer.getFirstName(), customer.getAddress(), customer.getMinit(),
                customer.getLastName(), customer.getBirthDate(), customer.getVerified(), customer.getNewsletter());
    }

    public void updateCustomer(final Customer customer) throws Exception {
        this.updateUser(customer);
        final String sql = "update customer set first_name=?,address=?,minit=?,last_name=?,birth_date=?,verified=?,newsletter=?"
                + "where c_username=?;";
        jdbcTemplate.update(sql, customer.getFirstName(), customer.getAddress(), customer.getMinit(), customer.getLastName(),
                customer.getBirthDate(), customer.getVerified(), customer.getNewsletter(), customer.getUsername());
    }

    public Optional<Customer> getCustomer(final String username) {
        final List<Customer> customer = this.jdbcTemplate.query("select * from customer,user where c_username=? and c_username=username", new Object[] {username}, new CustomerMapper());
        return customer.stream().findAny();
    }

    public List<Customer> getCustomers() {
        return this.jdbcTemplate.query("select * from customer,user where c_username=username", new CustomerMapper());
    }
}
