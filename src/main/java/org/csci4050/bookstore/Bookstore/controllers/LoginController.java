package org.csci4050.bookstore.Bookstore.controllers;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(required = false) final String error, @RequestParam(required = false) final String logout) {
        LoginViewModel loginViewModel = null;
        if (error != null) {
            loginViewModel = LoginViewModel.builder()
                    .message("You used an incorrect username or password. Please try to login again.")
                    .build();
        } else if (logout != null) {
            loginViewModel = LoginViewModel.builder()
                    .message("Logout successful.")
                    .build();
        }
        return new ModelAndView("views/index", "message", loginViewModel);
    }

    @Builder
    @Data
    public static class LoginViewModel {
        private String message;
    }
}
