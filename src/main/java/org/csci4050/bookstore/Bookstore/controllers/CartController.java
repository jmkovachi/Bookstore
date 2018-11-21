package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.CartItem;
import org.csci4050.bookstore.Bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * Example JSON request body:
     * {
     * 	"isbn": "9780091889487",
     * 	"cUsername": "jmkovachi",
     * 	"quantity": 3
     * }
     */
    @RequestMapping(value = "/add-item", method = RequestMethod.POST)
    public ResponseEntity<Object> addToCart(@RequestBody CartItem cartItem) throws ValidationException {
        cartService.insertCartItem(cartItem);
        return new ResponseEntity<>(cartItem, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Ex JSON:
     * {
     * 	"isbn": "9780091889487",
     * 	"cUsername": "jmkovachi",
     * 	"quantity": 1
     * }
     */
    @RequestMapping(value = "/update-item", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCartItem(@RequestBody CartItem cartItem) throws ValidationException {
        cartService.updateCartItem(cartItem);
        return new ResponseEntity<>(cartItem, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete-item/{username}/{isbn}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCartItem(@PathVariable final String username, @PathVariable final String isbn) {
        return null;
    }
}
