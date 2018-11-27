package org.csci4050.bookstore.Bookstore.controllers;

import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Customer;
import org.csci4050.bookstore.Bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/customer")

public class CustomerProfileController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Gson gson;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView customerProfile(final Principal principal, final Authentication authentication) throws ValidationException {
        final String username = principal.getName();
        final Customer customer = customerService.getCustomer(username).get();
        return new ModelAndView("views/profile-page", "customer", customer);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String registerCustomer(@RequestBody final String jsonCustomer, final Principal principal) throws ValidationException {
        final String username = principal.getName();
        final Customer customer = customerService.getCustomer(username).get();
        final Customer customerNew = gson.fromJson(jsonCustomer, Customer.class);
        customerNew.setUsername(customer.getUsername());
        customerNew.setPassword(customer.getPassword());
        customerNew.setMinit(customer.getMinit());
        customerNew.setImageUrl(customer.getImageUrl());
        customerNew.setVerified(customer.getVerified());
        customerNew.setRole(customer.getRole());

        return gson.toJson(customerService.updateCustomer(customerNew));
    }

}
