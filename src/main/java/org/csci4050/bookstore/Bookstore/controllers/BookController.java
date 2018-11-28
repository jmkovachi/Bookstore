package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Book;
import org.csci4050.bookstore.Bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book/insert", method = RequestMethod.POST)
    public ResponseEntity<Object> insertBook(@RequestBody final Book book) throws ValidationException {
        book.setDatePublished(new Date());
        book.setTotalInventory(1000);
        book.setPages(500);
        bookService.insertBook(book);
        return new ResponseEntity<>(book, new HttpHeaders(), HttpStatus.OK);
    }
}
