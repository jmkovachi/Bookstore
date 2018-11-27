package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.mappers.ShippingAddressMapper;
import org.csci4050.bookstore.Bookstore.model.ShippingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Optional;

public class ShippingAddressDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ShippingAddressDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createShippingAddress(final ShippingAddress shippingAddress) {
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        final String sql = "insert into shippingaddress(c_username,address,city,state,zip) values(?,?,?,?,?)";
        this.jdbcTemplate.update(connection -> {
            final PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, shippingAddress.getUsername());
            ps.setString(2, shippingAddress.getAddress());
            ps.setString(3, shippingAddress.getCity());
            ps.setString(4, shippingAddress.getState());
            ps.setInt(5, shippingAddress.getZip());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Optional<ShippingAddress> getShippingAddress(final int addressId) {
        final String sql = "select * from shippingaddress where address_id=?";
        return this.jdbcTemplate.query(sql, new Object[] {addressId}, new ShippingAddressMapper()).stream().findAny();
    }
}
