package org.csci4050.bookstore.Bookstore.viewmodel;

import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.model.Book;

import java.util.List;

@Data
@Builder
public class CatalogViewModel {
    private List<Book> books;
    private List<String> categories;
    private String username;
    private String viewCategory;
}
