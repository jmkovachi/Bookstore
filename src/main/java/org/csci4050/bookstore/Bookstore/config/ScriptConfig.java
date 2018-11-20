package org.csci4050.bookstore.Bookstore.config;

import org.csci4050.bookstore.Bookstore.scripts.InsertBooks;
import org.csci4050.bookstore.Bookstore.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScriptConfig {

    @Bean
    public InsertBooks insertBooks(final BookService bookService) {
        return new InsertBooks(bookService);
    }
}
