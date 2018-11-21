package org.csci4050.bookstore.Bookstore.config;

import org.csci4050.bookstore.Bookstore.scripts.InsertBooks;
import org.csci4050.bookstore.Bookstore.service.BookService;
import org.csci4050.bookstore.Bookstore.service.VendorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScriptConfig {

    @Bean
    public InsertBooks insertBooks(final BookService bookService, final VendorService vendorService) {
        return new InsertBooks(bookService, vendorService);
    }
}
