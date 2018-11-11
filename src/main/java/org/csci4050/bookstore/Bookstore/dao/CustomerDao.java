package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.model.Customer;
import org.csci4050.bookstore.Bookstore.util.ColumnValue;
import org.csci4050.bookstore.Bookstore.util.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserDao userDao;

    public void createCustomer(final String username, final String password, final String email, final String firstName, final String address,
                               final String minit, final String lastName, final String birthDate, final short verified, final short newsletter) {
        userDao.createUser(username,  password, email, "ROLE_CUSTOMER");
        this.jdbcTemplate.update("insert into customer(c_username,first_name,address,minit,last_name,birth_date,verified,newsletter) " +
                "values(?,?,?,?,?,?,?,?);", username, firstName, address, minit, lastName, birthDate, verified, newsletter);
    }

    public void updateCustomer(final String username, final String password, final String email, final String firstName, final String address, final String minit, final String lastName, final String birthDate, final Byte verified, final Byte newsletter) {
        userDao.updateUser(username, password, email);
        final List<ColumnValue> columnValues = new ArrayList<>();
        if (firstName != null) {
            columnValues.add(ColumnValue.builder()
                    .column(Customer.firstNameCol)
                    .value(firstName)
                    .build());
        }
        if (address != null) {
            columnValues.add(ColumnValue.builder()
                    .column(Customer.addressCol)
                    .value(address)
                    .build());
        }
        if (minit != null) {
            columnValues.add(ColumnValue.builder()
                    .column(Customer.minitCol)
                    .value(minit)
                    .build());
        }
        if (lastName != null) {
            columnValues.add(ColumnValue.builder()
                    .column(Customer.lastNameCol)
                    .value(lastName)
                    .build());
        }
        if (birthDate != null) {
            columnValues.add(ColumnValue.builder()
                    .column(Customer.birthDateCol)
                    .value(birthDate)
                    .build());
        }
        if (verified != null) {
            columnValues.add(ColumnValue.builder()
                    .column(Customer.verifiedCol)
                    .value(verified.toString())
                    .build());
        }
        if (newsletter != null) {
            columnValues.add(ColumnValue.builder()
                    .column(Customer.newsletterCol)
                    .value(newsletter.toString())
                    .build());
        }
        jdbcTemplate.update(SqlUtil.createSqlUpdateString("customer", (ColumnValue[]) columnValues.toArray()));
    }
}
