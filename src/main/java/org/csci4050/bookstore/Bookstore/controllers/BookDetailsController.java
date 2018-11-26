package org.csci4050.bookstore.Bookstore.controllers;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Book;
import org.csci4050.bookstore.Bookstore.service.BookService;
import org.csci4050.bookstore.Bookstore.viewmodel.BookDetailsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/details")
public class BookDetailsController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book/{isbn}", method = RequestMethod.GET)
    public ModelAndView bookDetails(@PathVariable final String isbn, final Principal principal) throws ValidationException {
        final String username = principal != null ? principal.getName() : null;
        final Book book = bookService.getBook(isbn).get();
        final BookDetailsModel bookDetailsModel = BookDetailsModel.builder()
                .username(username)
                .book(book)
                .build();
        return new ModelAndView("views/book-details", "book", bookDetailsModel);
    }
}
