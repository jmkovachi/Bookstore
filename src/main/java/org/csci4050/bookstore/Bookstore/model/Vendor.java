package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vendor extends User {
    private String company;
    private String address;
}
