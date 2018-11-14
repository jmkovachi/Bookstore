package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Vendor extends User implements Serializable {
    private String company;
    private String address;
}
