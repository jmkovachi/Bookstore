package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.mappers.OrderMapper;
import org.csci4050.bookstore.Bookstore.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class OrderDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createOrder(final Order order) {
        final String sql = "insert into `order`(c_username,total,payment_type,payment_id,address_id) values(?,?,?,?,?)";
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            final PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, order.getUsername());
            ps.setDouble(2, order.getTotal());
            ps.setString(3, order.getPaymentType());
            ps.setInt(4, order.getPaymentId());
            ps.setInt(5, order.getAddressId());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Optional<Order> getOrder(final int orderId) {
        final String sql = "select * from `order` where order_id=?";
        return this.jdbcTemplate.query(sql, new Object[] {orderId}, new OrderMapper()).stream().findAny();
    }

    /*public Double queryOrderByIsbn(final String isbn) {
        final String sql = "select SUM("
    }*/

    public List<Order> getOrdersFromLastDay() {
        final String sql = "select * from `order` where `order`.date between date_sub(now(),INTERVAL 1 DAY) and now()";
        return this.jdbcTemplate.query(sql, new OrderMapper());
    }
}
