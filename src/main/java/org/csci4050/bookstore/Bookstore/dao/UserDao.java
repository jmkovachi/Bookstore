package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.mapper.UserMapper;
import org.csci4050.bookstore.Bookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createUser(final String username, final String password, final String email, final String address, final Date birthDate) {
        this.jdbcTemplate.update("insert into insert into users(username,password,enabled,email,address,birth_date) " +
                "values(?,?,true,?,?,?,?);", username, password, email, address, birthDate.toString());
    }

    public Optional<User> getUser(final String username) {
        final List<User> user = this.jdbcTemplate.query("select * from users where users.username = \"" + username + "\"", new UserMapper());
        return user.stream().findAny();
    }
}
