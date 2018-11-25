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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
                                @RequestParam(required = false) final String genre,
                                final Principal principal) throws ValidationException {
        List<Book> books;
        final String viewCategory;
        final String viewString;
        if (isbn != null) {
            books = bookService.queryBooks("isbn", isbn);
            viewCategory = "ISBN";
            viewString = isbn;
        } else if (author != null) {
            books = bookService.queryBooks("author", author);
            viewCategory = "Author";
            viewString = author;
        } else if (title != null) {
            books = bookService.queryBooks("title", author);
            viewCategory = "Title";
            viewString = title;
        } else if (genre != null) {
            books = bookService.getBooksByColumns("category", genre);
            viewCategory = "Category";
            viewString = genre;
        } else {
            books = bookService.getBooks();
            viewCategory = null;
            viewString = null;
        }

        // filter books where inventory > 0 and sort by title
        books = books.stream()
                .filter(book -> book.getTotalInventory() > 0)
                .sorted(Comparator.comparing(Book::getTitle).thenComparing(Book::getAuthor))
                .collect(Collectors.toList());
        final List<String> categories = bookService.getCategoryValues();
        //final String username = principal.getName();

        final CatalogViewModel catalogViewModel = CatalogViewModel.builder()
                .username("jmkovachi")
                .books(books)
                .viewCategory((viewCategory != null) ? viewCategory.toLowerCase() : null)
                .viewString(viewString)
                .categories(categories)
                .build();
        return new ModelAndView("views/catalog", "catalog", catalogViewModel);
    }
}
