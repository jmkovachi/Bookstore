package org.csci4050.bookstore.Bookstore.dao;

import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.mappers.BookMapper;
import org.csci4050.bookstore.Bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

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
        final String sql = "update book set title=?,date_published=?,author=?,category=?,price=?,total_inventory=?," +
                "promo_id=?,image_url=?,rating=?,summary=?,pages=?,v_username=? where isbn=?";
        jdbcTemplate.update(sql, book.getTitle(), book.getDatePublished(), book.getAuthor(), book.getCategory(),
                book.getPrice(), book.getTotalInventory(), book.getPromoId(), book.getImageUrl(),
                book.getRating(), book.getSummary(), book.getPages(), book.getVUsername(), book.getIsbn());
    }

    public void deleteBook(final String isbn) {
        final String sql = "delete from book where isbn=?";
        jdbcTemplate.update(sql, isbn);
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

    public List<Book> getBooksWithInventoryLessThanNum(final int inventoryNum) {
        final String sql = "select * from book where total_inventory < ?";
        return this.jdbcTemplate.query(sql, new Object[] {inventoryNum}, new BookMapper());
    }

    public List<String> getValuesByColumn(final String column) {
        return this.jdbcTemplate.query("select distinct " + column + " from book", (rs, rownumber) -> rs.getString(column));
    }

    public List<IsbnWithCount> getBestSellingBookFromLastDay() {
        final String sql =
                "SELECT isbn, COUNT(isbn) as isbncount FROM `orderitem`,`order` " +
                "where `order`.order_id=`orderitem`.order_id and `order`.date between date_sub(now(),INTERVAL 1 DAY) and now()" +
                " GROUP BY `isbn` ORDER BY isbncount DESC LIMIT    1;";
        return this.jdbcTemplate.query(sql, (rs, rn) -> {
            return IsbnWithCount.builder()
                    .isbn(rs.getString("isbn"))
                    .count(rs.getInt("isbncount"))
                    .build();
        });
    }

    @Data
    @Builder
    public static class IsbnWithCount {
        private String isbn;
        private int count;
    }
}
