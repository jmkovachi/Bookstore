package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class OrderItemDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderItemDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createOrderItem(final OrderItem orderItem) {
        final String sql = "insert into orderitem(order_id,isbn,final_price) values(?,?,?)";
        this.jdbcTemplate.update(sql, orderItem.getOrderId(), orderItem.getIsbn(), orderItem.getFinalPrice());
    }

    public void deleteOrderItemsForOrderId(final int orderId) {
        final String sql = "delete from orderitem where order_id = ?";
        this.jdbcTemplate.update(sql, orderId);
    }
}
