package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/delete/{username}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable final String username) {
        userService.deleteUser(username);
        return new ResponseEntity<>("", new HttpHeaders(), HttpStatus.OK);
    }

}
