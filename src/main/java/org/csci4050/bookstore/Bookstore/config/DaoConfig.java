package org.csci4050.bookstore.Bookstore.config;

import org.csci4050.bookstore.Bookstore.dao.*;
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
    public CustomerDao customerDao(final JdbcTemplate jdbcTemplate) {
        return new CustomerDao(jdbcTemplate);
    }

    @Bean
    public ClientDao clientDao(final JdbcTemplate jdbcTemplate) {
        return new ClientDao(jdbcTemplate);
    }

    @Bean
    public BookDao bookDao(final JdbcTemplate jdbcTemplate) {
        return new BookDao(jdbcTemplate);
    }

    @Bean
    public PromotionDao promotionDao(final JdbcTemplate jdbcTemplate) { return new PromotionDao(jdbcTemplate); }

    @Bean
    public VerificationDao verificationDao(final JdbcTemplate jdbcTemplate) {
        return new VerificationDao(jdbcTemplate);
    }

    @Bean
    public CartDao cartDao(final JdbcTemplate jdbcTemplate) {
        return new CartDao(jdbcTemplate);
    }

    @Bean
    public OrderDao orderDao(final JdbcTemplate jdbcTemplate) {
        return new OrderDao(jdbcTemplate);
    }

    @Bean
    public PaymentDao paymentDao(final JdbcTemplate jdbcTemplate) {
        return new PaymentDao(jdbcTemplate);
    }

    @Bean
    public OrderItemDao orderItemDao(final JdbcTemplate jdbcTemplate) {
        return new OrderItemDao(jdbcTemplate);
    }

}
