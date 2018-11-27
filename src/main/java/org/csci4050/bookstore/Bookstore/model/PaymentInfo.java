package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PaymentInfo {
    private int paymentId;
    private String username;
    private String cardNum;
    private Date expDate;
    private Integer securityCode;
}
