package org.csci4050.bookstore.Bookstore.controllers;


import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Customer;
import org.csci4050.bookstore.Bookstore.service.CustomerService;
import org.csci4050.bookstore.Bookstore.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping(value="/edit")
public class EditProfileController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value = "/profile")
    public ModelAndView editProfile(final Principal principal) throws ValidationException {
        final String username = principal != null ? principal.getName() : null;
        final Customer customer = customerService.getCustomer(username).get();
        return new ModelAndView("views/edit-profile", "customer", customer);
    }

}
