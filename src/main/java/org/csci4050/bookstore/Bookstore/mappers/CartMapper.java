package org.csci4050.bookstore.Bookstore.mappers;

import org.csci4050.bookstore.Bookstore.model.CartItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartMapper implements RowMapper<CartItem> {

    @Override
    public CartItem mapRow(final ResultSet rs, final int rownumber) throws SQLException {
        return CartItem.builder()
                .isbn(rs.getString("isbn"))
                .cUsername(rs.getString("c_username"))
                .finalPrice(rs.getDouble("final_price"))
                .quantity(rs.getInt("quantity"))
                .build();
    }
}
