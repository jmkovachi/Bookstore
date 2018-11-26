package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShippingAddress {
    private Integer addressId;
    private String username;
    private String address;
    private String city;
    private String state;
    private Integer zip;
}
