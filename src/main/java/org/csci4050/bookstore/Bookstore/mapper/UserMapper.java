package org.csci4050.bookstore.Bookstore.mapper;

import org.csci4050.bookstore.Bookstore.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(final ResultSet rs, final int rownumber) throws SQLException {
        return User.builder()
                .username(rs.getString("username"))
                .password(rs.getString("password"))
                .email(rs.getString("email"))
                .build();
    }

}
