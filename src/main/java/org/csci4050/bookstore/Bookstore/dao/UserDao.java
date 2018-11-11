package org.csci4050.bookstore.Bookstore.dao;

import lombok.NoArgsConstructor;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.mappers.UserMapper;
import org.csci4050.bookstore.Bookstore.model.User;
import org.csci4050.bookstore.Bookstore.util.ColumnValue;
import org.csci4050.bookstore.Bookstore.util.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createUser(final String username, final String password, final String email, final String role, final String imageUrl) {
        this.jdbcTemplate.update("insert into user(username,password,email,role,image_url) " +
                "values(?,?,?,?,?);", username, password, email, role, imageUrl);
    }

    public void updateUser(final String username, final String password, final String email) throws ValidationException {
        final List<ColumnValue> columnValues = new ArrayList<>();
        final Optional<User> pre = getUser(username);
        if (!pre.isPresent()) throw new ValidationException("Username does not exist");
        if (password != null) {
            columnValues.add(ColumnValue.columnValue(User.PASSWORD_COL, password));
        }
        if (email != null) {
            columnValues.add(ColumnValue.columnValue(User.EMAIL_COL, email));
        }
        String sql = SqlUtil.createSqlUpdateString("user", columnValues);
        sql += "where username = " + "\"" + username + "\";";
        jdbcTemplate.update(sql);
    }

    public Optional<User> getUser(final String username) {
        final List<User> user = this.jdbcTemplate.query("select * from user where user.username = \"" + username + "\"", new UserMapper());
        return user.stream().findAny();
    }

    public List<User> getUsers() {
        return this.jdbcTemplate.query("select * from user", new UserMapper());
    }

}
