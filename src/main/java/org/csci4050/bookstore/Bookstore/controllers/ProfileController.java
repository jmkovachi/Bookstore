package org.csci4050.bookstore.Bookstore.controllers;


import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping(value = "/profile")

public class ProfileController {

    @RequestMapping(value = "/direct", method = RequestMethod.GET)
    public ModelAndView userProfile(final Principal principal, final Authentication authentication) throws ValidationException {
        try {
            final String username = principal.getName();
            final Optional<? extends GrantedAuthority> authority = authentication.getAuthorities().stream().findAny();
            if (!authority.isPresent()) {
                throw new ValidationException("no role assigned%s");
            } else {
                final String role = authority.get().getAuthority();
                switch (role) {
                    case "ROLE_CUSTOMER":
                        return new ModelAndView("redirect:/customer/view");
                    case "ROLE_VENDOR":
                        return new ModelAndView("redirect:/vendor/view");
                    case "ROLE_CLIENT":
                        return new ModelAndView("redirect:/client/view");
                    default:
                        throw new ValidationException("invalid role%s", username);
                }
            }
        } catch (Exception e){
            return new ModelAndView("redirect:/login");
        }
    }
}
