package org.csci4050.bookstore.Bookstore.viewmodel;

import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.controllers.BookDetailsController;
import org.csci4050.bookstore.Bookstore.model.Book;

@Data
@Builder
public class BookDetailsModel {
    private Book book;
    private String username;
}
