package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.mappers.CartMapper;
import org.csci4050.bookstore.Bookstore.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class CartDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CartDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createCartItem(final CartItem cartItem) {
        final String sql = "insert into cart(isbn,c_username,quantity,final_price) values(?,?,?,?);";
        this.jdbcTemplate.update(sql, cartItem.getIsbn(), cartItem.getCUsername(), cartItem.getQuantity(), cartItem.getFinalPrice());
    }

    public void updateCartItem(final CartItem cartItem) {
        final String sql = "update cart set quantity=?,final_price=? where isbn=? and c_username=?";
        this.jdbcTemplate.update(sql, cartItem.getQuantity(), cartItem.getFinalPrice(), cartItem.getIsbn(), cartItem.getCUsername());
    }

    public List<CartItem> getCartForCustomer(final String username) {
        return this.jdbcTemplate.query("select * from cart where c_username=?", new Object[] {username}, new CartMapper());
    }

    public Optional<CartItem> getCartItem(final String isbn, final String username) {
        final List<CartItem> cartItem = this.jdbcTemplate.query("select * from cart where isbn=? and c_username=?;", new Object[] {isbn, username}, new CartMapper());
        return cartItem.stream().findAny();
    }
}
