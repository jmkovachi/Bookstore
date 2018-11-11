package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.mappers.CustomerMapper;
import org.csci4050.bookstore.Bookstore.model.Customer;
import org.csci4050.bookstore.Bookstore.util.ColumnValue;
import org.csci4050.bookstore.Bookstore.util.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDao extends UserDao {

    private final String tableName = "customer";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createCustomer(final String username, final String password, final String email, final String imageUrl, final String firstName, final String address,
                               final String minit, final String lastName, final String birthDate, final Byte verified, final Byte newsletter) {
        this.createUser(username,  password, email, "ROLE_CUSTOMER", imageUrl);
        this.jdbcTemplate.update("insert into customer(c_username,first_name,address,minit,last_name,birth_date,verified,newsletter) " +
                "values(?,?,?,?,?,?,?,?);", username, firstName, address, minit, lastName, birthDate, verified.toString(), newsletter.toString());
    }

    public void updateCustomer(final String username, final String password, final String email, final String firstName, final String address, final String minit, final String lastName,
                               final String birthDate, final Byte verified, final Byte newsletter) throws Exception {
        this.updateUser(username, password, email);
        final List<ColumnValue> columnValues = new ArrayList<>();
        if (firstName != null) {
            columnValues.add(ColumnValue.builder()
                    .column(Customer.FIRST_NAME_COL)
                    .value(firstName)
                    .build());
        }
        if (address != null) {
            columnValues.add(ColumnValue.builder()
                    .column(Customer.ADDRESS_COL)
                    .value(address)
                    .build());
        }
        if (minit != null) {
            columnValues.add(ColumnValue.builder()
                    .column(Customer.MINIT_COL)
                    .value(minit)
                    .build());
        }
        if (lastName != null) {
            columnValues.add(ColumnValue.builder()
                    .column(Customer.LAST_NAME_COL)
                    .value(lastName)
                    .build());
        }
        if (birthDate != null) {
            columnValues.add(ColumnValue.builder()
                    .column(Customer.BIRTH_DATE_COL)
                    .value(birthDate)
                    .build());
        }
        if (verified != null) {
            columnValues.add(ColumnValue.builder()
                    .column(Customer.VERIFIED_COL)
                    .value(verified.toString())
                    .build());
        }
        if (newsletter != null) {
            columnValues.add(ColumnValue.builder()
                    .column(Customer.NEWSLETTER_COL)
                    .value(newsletter.toString())
                    .build());
        }
        String sql = SqlUtil.createSqlUpdateString("customer", columnValues);
        sql += "where c_username = " + "\"" + username + "\";";
        jdbcTemplate.update(sql);
    }

    public Optional<Customer> getCustomer(final String username) {
        final List<Customer> customer = this.jdbcTemplate.query("select * from customer where customer.c_username = \"" + username + "\"", new CustomerMapper());
        return customer.stream().findAny();
    }

    public List<Customer> getCustomers() {
        return this.jdbcTemplate.query("select * from customer", new CustomerMapper());
    }
}
