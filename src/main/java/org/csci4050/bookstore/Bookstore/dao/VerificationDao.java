package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.mappers.VerificationMapper;
import org.csci4050.bookstore.Bookstore.model.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class VerificationDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public VerificationDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createVerification(final String cUserName, final String email) {
        this.jdbcTemplate.update("insert into verification(c_username, email) values(?,?)", cUserName, email);
    }

    public Optional<Verification> getVerification(final String verificationCode) {
        final List<Verification> verification = this.jdbcTemplate.query("select * from verification where verification_code=?",
                new Object[] {verificationCode}, new VerificationMapper());
        return verification.stream().findAny();
    }

    public Optional<Verification> getVerification(final String cUsername, final String email) {
        final List<Verification> verification = this.jdbcTemplate.query("select * from verification where c_username=? and email=?",
                new Object[] {cUsername, email}, new VerificationMapper());
        return verification.stream().findAny();
    }
}
