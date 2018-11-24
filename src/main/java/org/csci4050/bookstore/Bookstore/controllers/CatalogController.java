package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Book;
import org.csci4050.bookstore.Bookstore.service.BookService;
import org.csci4050.bookstore.Bookstore.viewmodel.CatalogViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class CatalogController {

    private BookService bookService;

    @Autowired
    public CatalogController(final BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public ModelAndView catalog(@RequestParam(required = false) final String isbn,
                                @RequestParam(required = false) final String author,
                                @RequestParam(required = false) final String title,
                                @RequestParam(required = false) final String category,
                                final Principal principal) throws ValidationException {
        final List<Book> books;
        final String viewCategory;
        if (isbn != null) {
            books = bookService.queryBooks("isbn", isbn);
            viewCategory = "ISBN";
        } else if (author != null) {
            books = bookService.queryBooks("author", author);
            viewCategory = "Author";
        } else if (title != null) {
            books = bookService.queryBooks("title", author);
            viewCategory = "Title";
        } else if (category != null) {
            books = bookService.queryBooks("category", category);
            viewCategory = "Category";
        } else {
            books = bookService.getBooks();
            viewCategory = null;
        }
        final List<String> categories = bookService.getCategoryValues();
        final String username = "jmkovachi";//principal.getName();

        final CatalogViewModel catalogViewModel = CatalogViewModel.builder()
                .username(username)
                .books(books)
                .viewCategory(viewCategory)
                .categories(categories)
                .build();
        return new ModelAndView("views/catalog", "catalog", catalogViewModel);
    }
}
