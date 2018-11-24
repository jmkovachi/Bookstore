package org.csci4050.bookstore.Bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CartItem {
    private String isbn;
    private String cUsername;
    private Integer quantity;
    private Double finalPrice;
    private Double originalPrice;
}
