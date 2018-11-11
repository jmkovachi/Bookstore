package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Customer extends User {
    private String firstName;
    private String minit;
    private String lastName;
    private String address;
    private Date birthDate;
    private boolean verified;
    private boolean newsletter;
}
