package org.csci4050.bookstore.Bookstore.mappers;

import org.csci4050.bookstore.Bookstore.model.ShippingAddress;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShippingAddressMapper implements RowMapper<ShippingAddress> {

    @Override
    public ShippingAddress mapRow(final ResultSet rs, final int rownumber) throws SQLException {
        return ShippingAddress.builder()
                .address(rs.getString("address"))
                .addressId(rs.getInt("address_id"))
                .city(rs.getString("city"))
                .state(rs.getString("state"))
                .username(rs.getString("username"))
                .zip(rs.getInt("zip"))
                .build();
    }
}
