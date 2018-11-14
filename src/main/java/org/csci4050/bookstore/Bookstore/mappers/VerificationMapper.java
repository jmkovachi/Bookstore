package org.csci4050.bookstore.Bookstore.mappers;

import org.csci4050.bookstore.Bookstore.model.Verification;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificationMapper implements RowMapper<Verification> {

    @Override
    public Verification mapRow(final ResultSet rs, final int rownumber) throws SQLException {
        return Verification.builder()
                .verificationCode(rs.getInt("verification_code"))
                .cUserName(rs.getString("c_username"))
                .email(rs.getString("email"))
                .build();
    }
}
