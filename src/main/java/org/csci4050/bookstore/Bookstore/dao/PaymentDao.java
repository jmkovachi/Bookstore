package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.model.PaymentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PaymentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PaymentDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createPayment(final PaymentInfo paymentInfo) {
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        final String sql = "insert into paymentinfo(c_username,card_num,exp_date,security_code) values(?,?,?,?)";
        jdbcTemplate.update(connection -> {
            final PreparedStatement ps = connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paymentInfo.getUsername());
            ps.setString(2, paymentInfo.getCardNum());
            ps.setDate(3, new Date(paymentInfo.getExpDate().getTime()));
            ps.setInt(4, paymentInfo.getSecurityCode());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public void deletePayment(final int paymentId) {
        final String sql = "delete from paymentinfo where payment_id = ?";
        this.jdbcTemplate.update(sql, paymentId);
    }
}
