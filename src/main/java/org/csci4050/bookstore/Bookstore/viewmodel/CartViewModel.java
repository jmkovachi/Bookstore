package org.csci4050.bookstore.Bookstore.viewmodel;

import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.model.CartItem;

import java.util.List;

@Data
@Builder
public class CartViewModel {
    private String username;
    private List<CartItem> cartItems;
    private Double totalAmount;
}
