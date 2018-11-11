package org.csci4050.bookstore.Bookstore.mappers;

import org.csci4050.bookstore.Bookstore.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(final ResultSet rs, final int rownumber) throws SQLException {
        return Book.builder()
                .isbn(rs.getString("book"))
                .author(rs.getString("author"))
                .category(rs.getString("category"))
                .datePublished(rs.getDate("date_published"))
                .imageUrl(rs.getString("image_url"))
                .pages(rs.getInt("pages"))
                .price(rs.getDouble("price"))
                .promoId(rs.getInt("promoId"))
                .rating(rs.getFloat("rating"))
                .summary(rs.getString("summary"))
                .title(rs.getString("title"))
                .totalInventory(rs.getInt("total_inventory"))
                .vUsername(rs.getString("v_username"))
                .build();
    }
}
