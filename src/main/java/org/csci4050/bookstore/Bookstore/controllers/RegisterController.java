package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.model.Customer;
import org.csci4050.bookstore.Bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "customer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String registerCustomer(@RequestBody final Customer customer) throws Exception {
        customerService.registerCustomer(customer);
        return "redirect:/login";
    }
}
