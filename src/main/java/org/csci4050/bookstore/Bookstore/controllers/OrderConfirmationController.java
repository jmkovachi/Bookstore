package org.csci4050.bookstore.Bookstore.controllers;

import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.*;
import org.csci4050.bookstore.Bookstore.service.BookService;
import org.csci4050.bookstore.Bookstore.service.OrderService;
import org.csci4050.bookstore.Bookstore.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class OrderConfirmationController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShippingAddressService shippingAddressService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/order/confirm/{orderId}", method = RequestMethod.GET)
    public ModelAndView orderConfirmation(@PathVariable final int orderId) throws ValidationException {
        orderService.sendOrderConfirmationEmail(orderId);
        final Optional<Order> optionalOrder = orderService.getOrder(orderId);
        final Order order = optionalOrder.get();
        final List<OrderItem> orderItems = orderService.getOrderItemsForOrderId(order.getOrderId());

        ShippingAddress shippingAddress = null;
        if (!order.getPaymentType().equals("CASH")) {
            shippingAddress = shippingAddressService.getShippingAddress(order.getAddressId()).get();
        }

        final OrderConfirmationInfo orderConfirmationInfo = OrderConfirmationInfo.builder()
                .order(order)
                .orderItemWithBooks(orderItems.stream().map(this::transformOrderItemToOrderItemWithBook).collect(Collectors.toList()))
                .build();

        return new ModelAndView("views/confirm-order", "confirm", orderConfirmationInfo);
    }

    @Data
    @Builder
    public static class OrderItemWithBook {
        private OrderItem orderItem;
        private Book book;
    }

    @Data
    @Builder
    public static class OrderConfirmationInfo {
        private Order order;
        private List<OrderItemWithBook> orderItemWithBooks;
        private ShippingAddress shippingAddress;
    }

    private OrderItemWithBook transformOrderItemToOrderItemWithBook(final OrderItem orderItem) {
        final Book book = bookService.getBook(orderItem.getIsbn()).get();
        return OrderItemWithBook.builder()
                .book(book)
                .orderItem(orderItem)
                .build();
    }

}
