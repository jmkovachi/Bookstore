package org.csci4050.bookstore.Bookstore.viewmodel;

import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.controllers.CartController;

import java.util.List;

@Data
@Builder
public class CartViewModel {
    private String username;
    private List<CartController.CartItemWithBook> cartItems;
    private Double totalAmount;
}
