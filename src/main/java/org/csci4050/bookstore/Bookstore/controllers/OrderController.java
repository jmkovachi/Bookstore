package org.csci4050.bookstore.Bookstore.controllers;

import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Order;
import org.csci4050.bookstore.Bookstore.model.OrderItem;
import org.csci4050.bookstore.Bookstore.model.PaymentInfo;
import org.csci4050.bookstore.Bookstore.model.ShippingAddress;
import org.csci4050.bookstore.Bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Gson gson;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<Object> order(@RequestBody final String checkoutInfoJson) throws ValidationException {
        final CheckoutInfo checkoutInfo = gson.fromJson(checkoutInfoJson, CheckoutInfo.class);
        final Order order = orderService.createOrder(checkoutInfo.getOrder(), checkoutInfo.getPaymentInfo(), checkoutInfo.getOrderItems());
        final OrderResponse orderResponse = OrderResponse.builder()
                .orderId(order.getOrderId())
                .build();
        return new ResponseEntity<>(orderResponse, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public String getOrder(@PathVariable final int orderId) throws ValidationException {
        final Optional<Order> orderOptional = orderService.getOrder(orderId);
        if (!orderOptional.isPresent()) {
            throw new ValidationException("Order with order id <%s> not present", Integer.toString(orderId));
        }
        final Order order = orderOptional.get();

    }

    @Data
    @Builder
    public static class CheckoutInfo {
        private Order order;
        private PaymentInfo paymentInfo;
        private ShippingAddress shippingAddress;
        private List<OrderItem> orderItems;
    }

    @Data
    @Builder
    public static class OrderResponse {
        private int orderId;
    }
}