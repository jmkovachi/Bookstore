package org.csci4050.bookstore.Bookstore.controllers;
import lombok.Builder;
import lombok.Data;
import org.apache.tomcat.util.http.parser.Authorization;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Book;
import org.csci4050.bookstore.Bookstore.model.CartItem;
import org.csci4050.bookstore.Bookstore.service.BookService;
import org.csci4050.bookstore.Bookstore.service.CartService;
import org.csci4050.bookstore.Bookstore.service.VendorService;
import org.csci4050.bookstore.Bookstore.viewmodel.CartViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView bookDetails(@RequestBody Book book) throws ValidationException {
        return new ModelAndView("views/book-details", "book", book);
    }
}
