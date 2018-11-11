package org.csci4050.bookstore.Bookstore.config;

import org.csci4050.bookstore.Bookstore.dao.BookDao;
import org.csci4050.bookstore.Bookstore.dao.ClientDao;
import org.csci4050.bookstore.Bookstore.dao.UserDao;
import org.csci4050.bookstore.Bookstore.dao.VendorDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DaoConfig {

    @Bean
    public UserDao userDao(final JdbcTemplate jdbcTemplate) {
        return new UserDao(jdbcTemplate);
    }

    @Bean
    public VendorDao vendorDao(final JdbcTemplate jdbcTemplate) {
        return new VendorDao(jdbcTemplate);
    }

    @Bean
    public ClientDao clientDao(final JdbcTemplate jdbcTemplate) {
        return new ClientDao(jdbcTemplate);
    }

    @Bean
    public BookDao bookDao(final JdbcTemplate jdbcTemplate) {
        return new BookDao(jdbcTemplate);
    }

}
