package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client extends User {
    private String name;
    private String company;
    private String address;

    public final static String NAME_COL = "NAME";
    public final static String COMPANY_COL = "COMPANY";
    public final static String ADDRESS_COL = "ADDRESS";
}
