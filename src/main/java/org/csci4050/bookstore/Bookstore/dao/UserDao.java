package org.csci4050.bookstore.Bookstore.dao;

import lombok.NoArgsConstructor;
import org.csci4050.bookstore.Bookstore.mappers.UserMapper;
import org.csci4050.bookstore.Bookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createUser(final User user) throws DataAccessException {
        this.jdbcTemplate.update("insert into user(username,password,email,role,image_url) " +
                "values(?,?,?,?,?);", user.getUsername(), user.getPassword(), user.getEmail(), user.getRole(), user.getImageUrl());
    }

    public void updateUser(final User user) {
        final String sql = "update user set password=?, email=?, role=?, image_url=? where username=?";
        jdbcTemplate.update(sql, user.getPassword(), user.getEmail(), user.getRole(), user.getImageUrl(), user.getUsername());
    }

    public Optional<User> getUser(final String username) {
        final List<User> user = this.jdbcTemplate.query("select * from user where user.username = ?", new Object[] {username}, new UserMapper());
        return user.stream().findAny();
    }

    public List<User> getUsers() {
        return this.jdbcTemplate.query("select * from user", new UserMapper());
    }

    public void deleteUser(final String username) {
        this.jdbcTemplate.query("delete from user where username=?", new Object[] {username}, new UserMapper());
    }

}
