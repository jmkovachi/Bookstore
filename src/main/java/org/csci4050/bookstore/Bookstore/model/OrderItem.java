package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItem {
    private Integer itemId;
    private Integer orderId;
    private String isbn;
    private Double finalPrice;
}
