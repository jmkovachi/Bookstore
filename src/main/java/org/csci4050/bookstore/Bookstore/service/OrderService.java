package org.csci4050.bookstore.Bookstore.service;

import org.csci4050.bookstore.Bookstore.dao.OrderDao;
import org.csci4050.bookstore.Bookstore.dao.OrderItemDao;
import org.csci4050.bookstore.Bookstore.dao.PaymentDao;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Customer;
import org.csci4050.bookstore.Bookstore.model.Order;
import org.csci4050.bookstore.Bookstore.model.OrderItem;
import org.csci4050.bookstore.Bookstore.model.PaymentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

public class OrderService {

    
    private OrderDao orderDao;

    private OrderItemDao orderItemDao;

    private CustomerService customerService;
    
    private PaymentDao paymentDao;

    @Autowired
    public OrderService(final OrderDao orderDao, final OrderItemDao orderItemDao,
                        final CustomerService customerService, final PaymentDao paymentDao) {
        this.orderDao = orderDao;
        this.orderItemDao = orderItemDao;
        this.customerService = customerService;
        this.paymentDao = paymentDao;
    }


    public Order createOrder(final Order order, final PaymentInfo paymentInfo, final List<OrderItem> orderItems) throws ValidationException {
        final Optional<Customer> customerOptional = customerService.getCustomer(order.getUsername());
        if (!customerOptional.isPresent()) {
            throw new ValidationException("Customer with username <%s> does not exist", order.getUsername());
        }
        if (orderItems.isEmpty()) {
            throw new ValidationException("Order has no order items");
        }

        Integer paymentId = null;
        if (order.getPaymentType().equals("CREDIT")) {
            paymentId = paymentDao.createPayment(paymentInfo);
            order.setPaymentId(paymentId);
        }
        final int orderId = orderDao.createOrder(order);
        try {
            for (final OrderItem item : orderItems) {
                orderItemDao.createOrderItem(item);
            }
        } catch (final DataAccessException da) {
            if (order.getPaymentType().equals("CREDIT")) {
                paymentDao.deletePayment(paymentId);
            }
            orderItemDao.deleteOrderItemsForOrderId(orderId);
            throw new ValidationException("Could not create order items for order <%s>", Integer.toString(orderId));
        }
        order.setOrderId(orderId);
        return order;
    }

    public Optional<Order> getOrder(final int orderId) {
        return orderDao.getOrder(orderId);
    }


}
