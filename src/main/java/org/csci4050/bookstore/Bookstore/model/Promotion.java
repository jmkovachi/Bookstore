package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Promotion {
    private Integer promoId;
    private String promoCode;
    private Double percentOff;
    private Date expireDate;
}
