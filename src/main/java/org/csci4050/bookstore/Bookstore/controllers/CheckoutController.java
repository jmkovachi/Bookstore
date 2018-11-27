package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.CartItem;
import org.csci4050.bookstore.Bookstore.model.Customer;
import org.csci4050.bookstore.Bookstore.service.CartService;
import org.csci4050.bookstore.Bookstore.service.CustomerService;
import org.csci4050.bookstore.Bookstore.viewmodel.CheckoutViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CheckoutController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public ModelAndView checkout(final Principal principal) throws ValidationException {
        //final String username = principal.getName();
        final String username = "jpreinold";
        final List<CartItem> cartItems = cartService.getCartForCustomer(username);

        // use java streams to calculate total price of all items
        final Double totalAmount = cartItems.stream()
                .map(CartItem::getFinalPrice)
                .reduce(0.0, (c1, c2) -> c1 + c2);

        final Customer customer = customerService.getCustomer(username).get();
        final CheckoutViewModel checkoutViewModel = CheckoutViewModel.builder()
                .cartItems(cartItems.stream().map(cartService::transformToCartItemWithBook).collect(Collectors.toList()))
                .customer(customer)
                .totalAmount(totalAmount)
                .build();
        return new ModelAndView("views/checkout", "checkout", checkoutViewModel);
    }

}

