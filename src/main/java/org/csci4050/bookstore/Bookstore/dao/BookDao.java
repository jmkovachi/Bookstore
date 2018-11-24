package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.mappers.BookMapper;
import org.csci4050.bookstore.Bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createBook(final Book book) {
        final String sql = "insert into book(isbn,title,date_published,author,category,price,total_inventory,promo_id," +
        "image_url,rating,summary,pages,v_username) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, book.getIsbn(), book.getTitle(), book.getDatePublished(), book.getAuthor(), book.getCategory(),
                book.getPrice(), book.getTotalInventory(), book.getPromoId(), book.getImageUrl(), book.getRating(),
                book.getSummary(), book.getPages(), book.getVUsername());
    }

    public void updateBook(final Book book) {
        final String sql = "update book set title=?,date_published=?,author=?,category=?,price=?,total_inventory=?" +
                "promo_id=?,image_url=?,rating=?,summary=?,pages=?,v_username=? where isbn=?";
        jdbcTemplate.update(sql, book.getTitle(), book.getDatePublished(), book.getAuthor(), book.getCategory(),
                book.getCategory(), book.getPrice(), book.getTotalInventory(), book.getPromoId(), book.getImageUrl(),
                book.getRating(), book.getSummary(), book.getPages(), book.getVUsername(), book.getIsbn());
    }

    public Optional<Book> getBook(final String isbn) {
        final List<Book> book = this.jdbcTemplate.query("select * from book where isbn=?", new Object[] {isbn}, new BookMapper());
        return book.stream().findAny();
    }

    public List<Book> getBooks() {
        return this.jdbcTemplate.query("select * from book", new BookMapper());
    }

    public List<Book> queryBooks(final String column, final String value) {
        final String sql = "select * from book where " + column + " like ?";
        return this.jdbcTemplate.query(sql, new Object[] {"%" + value + "%"}, new BookMapper());
    }

    public List<Book> getBooksByColumn(final String column, final String value) {
        final String sql = "select * from book where " + column + " = ?";
        return this.jdbcTemplate.query(sql, new Object[] {value}, new BookMapper());
    }

    public List<String> getValuesByColumn(final String column) {
        return this.jdbcTemplate.query("select distinct " + column + " from book", new RowMapper<>() {
            @Override
            public String mapRow(final ResultSet rs, final int rownumber) throws SQLException {
                return rs.getString(column);
            }
        });
    }
}
