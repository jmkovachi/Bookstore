package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItem {
    private String isbn;
    private String cUsername;
    private Integer quantity;
    private Double finalPrice;
}
