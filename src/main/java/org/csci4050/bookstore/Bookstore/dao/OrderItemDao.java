package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.mappers.OrderItemMapper;
import org.csci4050.bookstore.Bookstore.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderItemDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderItemDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createOrderItem(final OrderItem orderItem) {
        final String sql = "insert into orderitem(order_id,isbn,final_price,quantity) values(?,?,?,?)";
        this.jdbcTemplate.update(sql, orderItem.getOrderId(), orderItem.getIsbn(), orderItem.getFinalPrice(), orderItem.getQuantity());
    }

    public void deleteOrderItemsForOrderId(final int orderId) {
        final String sql = "delete from orderitem where order_id=?";
        this.jdbcTemplate.update(sql, orderId);
    }

    public List<OrderItem> getOrderItemsForOrderId(final int orderId) {
        final String sql = "select * from orderitem where order_id=?";
        return this.jdbcTemplate.query(sql, new Object[] {orderId}, new OrderItemMapper());
    }
}
