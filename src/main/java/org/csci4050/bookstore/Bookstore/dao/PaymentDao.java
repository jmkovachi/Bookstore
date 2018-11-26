package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.model.PaymentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class PaymentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PaymentDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createPayment(final PaymentInfo paymentInfo) {
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        final String sql = "insert into paymentinfo(c_username,card_num,exp_date,security_code) values(?,?,?,?)";
        this.jdbcTemplate.update(sql, paymentInfo.getUsername(), paymentInfo.getCardNum(), paymentInfo.getExpDate(),
                paymentInfo.getSecurityCode(), keyHolder);
        return keyHolder.getKey().intValue();
    }

    public void deletePayment(final int paymentId) {
        final String sql = "delete from payemntinfo where payment_id = ?";
        this.jdbcTemplate.update(sql, paymentId);
    }
}
