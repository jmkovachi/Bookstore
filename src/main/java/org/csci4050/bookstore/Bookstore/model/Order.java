package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Order {
    private Integer orderId;
    private String username;
    private Date date;
    private Double total;
    private String paymentType;
    private Integer paymentId;
    private Integer addressId;
}
