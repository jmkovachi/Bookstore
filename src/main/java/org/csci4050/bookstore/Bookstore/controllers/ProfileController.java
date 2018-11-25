package org.csci4050.bookstore.Bookstore.controllers;

import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Customer;
import org.csci4050.bookstore.Bookstore.model.User;
import org.csci4050.bookstore.Bookstore.service.UserService;
import org.csci4050.bookstore.Bookstore.service.ClientService;
import org.csci4050.bookstore.Bookstore.service.CustomerService;
import org.csci4050.bookstore.Bookstore.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.Collection;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/profile")

public class ProfileController {

    @RequestMapping(value = "/direct", method = RequestMethod.GET)
    public ModelAndView userProfile(final Principal principal, final Authentication authentication) throws ValidationException {
        final String username = principal.getName();
        final Optional<? extends GrantedAuthority> authority = authentication.getAuthorities().stream().findAny();
        if (!authority.isPresent()) {
            throw new ValidationException("no role%s", username);
        } else {
            final String role = authority.get().getAuthority();
            switch (role) {
                case "ROLE_CUSTOMER":
                    return new ModelAndView("redirect:/customer/view");
                case "ROLE_VENDOR":
                    return new ModelAndView("redirect:/vendor");
                case "ROLE_CLIENT":
                    return new ModelAndView("redirect:/client");
                default:
                    throw new ValidationException("invalid role%s", username);
            }
        }
    }
}
