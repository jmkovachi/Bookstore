package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.model.Customer;
import org.csci4050.bookstore.Bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;

@Controller
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Gson gson;

    @RequestMapping(value = "customer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String registerCustomer(@RequestBody final String jsonCustomer) throws Exception {
        final Customer customer = gson.fromJson(jsonCustomer, Customer.class);
        customerService.registerCustomer(customer);
        return gson.toJson(customer);
    }
}
