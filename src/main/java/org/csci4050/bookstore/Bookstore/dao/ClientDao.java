package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.mappers.UserMapper;
import org.csci4050.bookstore.Bookstore.model.Client;
import org.csci4050.bookstore.Bookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class ClientDao extends UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createClient(final Client client) throws ValidationException {
        this.createUser(client);
        final String sql = "insert into client(client_username,address,company,name) values(?,?,?,?);";
        this.jdbcTemplate.update(sql, client.getUsername(), client.getAddress(), client.getCompany(), client.getName());
    }

    public void updateClient(final Client client) throws ValidationException {
        this.updateUser(client);
        final String sql = "set client address=?, company=?, name=?, where client_username=?;";
        jdbcTemplate.update(sql, client.getAddress(), client.getCompany(), client.getName(), client.getUsername());
    }

    public Optional<User> getUser(final String username) {
        final List<User> user = this.jdbcTemplate.query("select * from user where user.username = ?;", new Object[] {username}, new UserMapper());
        return user.stream().findAny();
    }

    public List<User> getUsers() {
        return this.jdbcTemplate.query("select * from user;", new UserMapper());
    }
}
