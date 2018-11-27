package org.csci4050.bookstore.Bookstore.mappers;

import org.csci4050.bookstore.Bookstore.model.OrderItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemMapper implements RowMapper<OrderItem> {

    @Override
    public OrderItem mapRow(final ResultSet rs, final int rownumber) throws SQLException {
        return OrderItem.builder()
                .orderId(rs.getInt("order_id"))
                .isbn(rs.getString("isbn"))
                .finalPrice(rs.getDouble("final_price"))
                .itemId(rs.getInt("item_id"))
                .quantity(rs.getInt("quantity"))
                .build();
    }
}
