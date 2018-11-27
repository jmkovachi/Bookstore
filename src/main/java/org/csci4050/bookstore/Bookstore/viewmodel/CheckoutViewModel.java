package org.csci4050.bookstore.Bookstore.viewmodel;

import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.controllers.CartController;
import org.csci4050.bookstore.Bookstore.model.Customer;

import java.util.List;

@Data
@Builder
public class CheckoutViewModel {
    private Customer customer;
    private List<CartController.CartItemWithBook> cartItems;
    private Double totalAmount;
}

