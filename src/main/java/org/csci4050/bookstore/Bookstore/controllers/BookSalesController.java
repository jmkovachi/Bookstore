package org.csci4050.bookstore.Bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookSalesController {

    @RequestMapping(value = "/book-sales", method = RequestMethod.GET)
    public ModelAndView bookSales() {
        return new ModelAndView("views/book-sales", "bookSales", null);
    }


}