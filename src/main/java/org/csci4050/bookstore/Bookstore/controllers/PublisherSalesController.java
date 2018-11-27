package org.csci4050.bookstore.Bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublisherSalesController {

    @RequestMapping(value = "/publisher-sales", method = RequestMethod.GET)
    public ModelAndView viewPubSales() {
        return new ModelAndView("views/publisher-sales", "pubSales", null);
    }
}