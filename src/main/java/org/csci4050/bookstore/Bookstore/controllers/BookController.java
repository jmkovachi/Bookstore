package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Book;
import org.csci4050.bookstore.Bookstore.service.BookService;
import org.csci4050.bookstore.Bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/book/insert", method = RequestMethod.POST)
    public ResponseEntity<Object> insertBook(@RequestBody final Book book) throws ValidationException {
        book.setDatePublished(new Date());
        book.setTotalInventory(1000);
        book.setPages(500);
        bookService.insertBook(book);
        return new ResponseEntity<>(book, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/book/delete/{isbn}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBook(@PathVariable final String isbn, @RequestParam(required = false) final String vendor) throws ValidationException {
        if (vendor != null) {
            bookService.deleteBookForVendor(isbn, vendor);
        } else {
            bookService.deleteBook(isbn);
        }
        return new ResponseEntity<>("", new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/book/metadata/{isbn}", method = RequestMethod.GET)
    public ResponseEntity<Object> getBook(@PathVariable final String isbn) throws ValidationException {
        final Optional<Book> bookOptional = bookService.getBook(isbn);
        if (!bookOptional.isPresent()) {
            throw new ValidationException("Book with isbn <%s> does not exist", isbn);
        }

        return new ResponseEntity<>(bookOptional.get(), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/book/metadata/sales/{isbn}", method = RequestMethod.GET)
    public ResponseEntity<Object> getBookSales(@PathVariable final String isbn) throws ValidationException {
        final Optional<Book> bookOptional = bookService.getBook(isbn);
        if (!bookOptional.isPresent()) {
            throw new ValidationException("Book with isbn <%s> does not exist", isbn);
        }


        return new ResponseEntity<>(bookOptional.get(), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/book/update", method = RequestMethod.POST)
    public ResponseEntity<Object> updateBook(@RequestBody final Book book) throws ValidationException {
        bookService.updateBook(book);
        return new ResponseEntity<>("", new HttpHeaders(), HttpStatus.OK);
    }
}
