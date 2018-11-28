package org.csci4050.bookstore.Bookstore.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class AuthController {

    @RequestMapping("/access-denied")
    public String accessDenied() {
        return "views/permission-deny";
    }
}
