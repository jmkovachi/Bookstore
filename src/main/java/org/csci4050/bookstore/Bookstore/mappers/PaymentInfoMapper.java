package org.csci4050.bookstore.Bookstore.mappers;

import org.csci4050.bookstore.Bookstore.model.PaymentInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentInfoMapper implements RowMapper<PaymentInfo> {

    @Override
    public PaymentInfo mapRow(final ResultSet rs, final int rownumber) throws SQLException {
        return PaymentInfo.builder()
                .cardNum(rs.getString("card_num"))
                .expDate(rs.getDate("exp_date"))
                .username(rs.getString("c_username"))
                .securityCode(rs.getInt("security_code"))
                .paymentId(rs.getInt("payement_id"))
                .build();
    }
}
