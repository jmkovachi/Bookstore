package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client extends User {
    private String name;
    private String company;
    private String address;
}
