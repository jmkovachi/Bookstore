package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.mappers.ShippingAddressMapper;
import org.csci4050.bookstore.Bookstore.model.ShippingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

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
        this.jdbcTemplate.update(sql, shippingAddress.getUsername(),shippingAddress.getAddress(),
                shippingAddress.getCity(),shippingAddress.getState(),shippingAddress.getZip(), keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Optional<ShippingAddress> getShippingAddress(final int addressId) {
        final String sql = "select * from shippingaddress where address_id=?";
        return this.jdbcTemplate.query(sql, new Object[] {addressId}, new ShippingAddressMapper()).stream().findAny();
    }
}
