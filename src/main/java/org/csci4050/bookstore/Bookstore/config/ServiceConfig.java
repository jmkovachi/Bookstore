package org.csci4050.bookstore.Bookstore.config;

import org.csci4050.bookstore.Bookstore.dao.*;
import org.csci4050.bookstore.Bookstore.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class ServiceConfig {

    @Bean
    public CustomerService customerService(final CustomerDao customerDao, final UserDao userDao) {
        return new CustomerService(customerDao, userDao);
    }

    @Bean
    public VendorService vendorService(final VendorDao vendorDao){
        return new VendorService(vendorDao);
    }

    @Bean
    public ClientService clientService(final ClientDao clientDao) {
        return new ClientService(clientDao);
    }

    @Bean
    public VerificationService verificationService(final JavaMailSender javaMailSender,
                                                   final VerificationDao verificationDao,
                                                   final CustomerService customerService) {
        return new VerificationService(javaMailSender, verificationDao, customerService);
    }

    @Bean
    public CartService cartService(final CartDao cartDao,
                                   final CustomerService customerService,
                                   final BookService bookService,
                                   final PromotionService promotionService,
                                   final VendorService vendorService) {
        return new CartService(cartDao, customerService, bookService, promotionService, vendorService);
    }

    @Bean
    public BookService bookService(final BookDao bookDao, final PromotionService promotionService, final VendorService vendorService) {
        return new BookService(bookDao, promotionService, vendorService);
    }

    @Bean
    public PromotionService promotionService(final PromotionDao promotionDao) {
        return new PromotionService(promotionDao);
    }

    @Bean
    public OrderService orderService(final CustomerService customerService, final PaymentDao paymentDao,
                                     final OrderItemDao orderItemDao, final OrderDao orderDao) {
        return new OrderService(orderDao, orderItemDao, customerService, paymentDao);
    }
}
