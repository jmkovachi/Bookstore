package org.csci4050.bookstore.Bookstore.mappers;

import org.csci4050.bookstore.Bookstore.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(final ResultSet rs, final int rownumber) throws SQLException {
        final User user = new User();
        user.setUsername(rs.getString(User.USERNAME_COL));
        user.setPassword(rs.getString(User.PASSWORD_COL));
        user.setEmail(rs.getString(User.EMAIL_COL));
        user.setImageUrl(rs.getString(User.IMAGE_URL_COL));
        return user;
    }
    
    public static User setUserFromResultSet(final User user, final ResultSet rs) throws SQLException {
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setImageUrl(rs.getString("image_url"));
        return user;
    }

}
