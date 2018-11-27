package org.csci4050.bookstore.Bookstore.mappers;

import org.csci4050.bookstore.Bookstore.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(final ResultSet rs, final int rownumber) throws SQLException {
        return Order.builder()
                .date(rs.getDate("date"))
                .username(rs.getString("c_username"))
                .orderId(rs.getInt("order_id"))
                .paymentType(rs.getString("payment_type"))
                .total(rs.getDouble("total"))
                .paymentId(rs.getInt("payment_id"))
                .addressId(rs.getInt("address_id"))
                .build();
    }
}
