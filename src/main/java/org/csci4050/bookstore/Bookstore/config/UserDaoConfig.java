package org.csci4050.bookstore.Bookstore.config;

import org.csci4050.bookstore.Bookstore.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class UserDaoConfig {

    @Bean
    public UserDao userDao(final JdbcTemplate jdbcTemplate) {
        return new UserDao(jdbcTemplate);
    }

}
