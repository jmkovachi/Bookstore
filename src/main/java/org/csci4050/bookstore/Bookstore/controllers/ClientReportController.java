package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.model.Book;
import org.csci4050.bookstore.Bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClientReportController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/low-inv-notice", method = RequestMethod.GET)
    public ModelAndView lowinv() {
        final List<Book> lowInventoryBooks = bookService.getLowInventoryBooks();

        return new ModelAndView("views/low-inv-notice", "lowinv", null);
    }


}