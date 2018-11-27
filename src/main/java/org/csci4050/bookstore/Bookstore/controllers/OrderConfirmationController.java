package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Order;
import org.csci4050.bookstore.Bookstore.model.OrderItem;
import org.csci4050.bookstore.Bookstore.model.ShippingAddress;
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

@Controller
public class OrderConfirmationController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShippingAddressService shippingAddressService;

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

        final OrderController.CheckoutInfo checkoutInfo = OrderController.CheckoutInfo.builder()
                .order(order)
                .orderItems(orderItems)
                .shippingAddress(shippingAddress)
                .build();

        return new ModelAndView("views/confirm-order", "confirm", checkoutInfo);
    }


}
