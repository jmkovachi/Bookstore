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
                                   final VendorService vendorService) {
        return new CartService(cartDao, customerService, bookService, vendorService);
    }

    @Bean
    public BookService bookService(final BookDao bookDao, final VendorService vendorService) {
        return new BookService(bookDao, vendorService);
    }

    @Bean
    public PromotionService promotionService(final PromotionDao promotionDao, final CartService cartService) {
        return new PromotionService(promotionDao, cartService);
    }

    @Bean
    public OrderService orderService(final CustomerService customerService, final PaymentDao paymentDao,
                                     final OrderItemDao orderItemDao, final OrderDao orderDao,
                                     final BookService bookService, final CartService cartService,
                                     final ShippingAddressService shippingAddressService, final JavaMailSender javaMailSender) {
        return new OrderService(orderDao, orderItemDao, customerService, paymentDao, bookService,
                cartService, shippingAddressService, javaMailSender);
    }

    @Bean
    public ShippingAddressService shippingAddressService(final ShippingAddressDao shippingAddressDao) {
        return new ShippingAddressService(shippingAddressDao);
    }
}
