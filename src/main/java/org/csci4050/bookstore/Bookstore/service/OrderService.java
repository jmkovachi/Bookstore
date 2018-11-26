package org.csci4050.bookstore.Bookstore.service;

import org.csci4050.bookstore.Bookstore.dao.OrderDao;
import org.csci4050.bookstore.Bookstore.dao.OrderItemDao;
import org.csci4050.bookstore.Bookstore.dao.PaymentDao;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderService {

    
    private OrderDao orderDao;

    private OrderItemDao orderItemDao;

    private CustomerService customerService;
    
    private PaymentDao paymentDao;

    private BookService bookService;

    private CartService cartService;

    private ShippingAddressService shippingAddressService;

    @Autowired
    public OrderService(final OrderDao orderDao, final OrderItemDao orderItemDao,
                        final CustomerService customerService, final PaymentDao paymentDao,
                        final BookService bookService, final CartService cartService,
                        final ShippingAddressService shippingAddressService) {
        this.orderDao = orderDao;
        this.orderItemDao = orderItemDao;
        this.customerService = customerService;
        this.paymentDao = paymentDao;
        this.bookService = bookService;
        this.cartService = cartService;
        this.shippingAddressService = shippingAddressService;
    }


    public Order createOrder(final Order order, final PaymentInfo paymentInfo, final ShippingAddress shippingAddress, final List<OrderItem> orderItems) throws ValidationException {
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

        // create shipping address
        shippingAddressService.createShippingAddress(shippingAddress);

        // use java streams to calculate total price of all items
        final Double totalAmount = orderItems.stream()
                .map(OrderItem::getFinalPrice)
                .reduce(0.0, (c1, c2) -> c1 + c2);

        order.setTotal(totalAmount);

        final int orderId = orderDao.createOrder(order);

        // set order id for each order item
        orderItems.forEach(orderItem -> orderItem.setOrderId(orderId));

        final List<Book> oldBooks = new ArrayList<>();
        try {
            for (final OrderItem item : orderItems) {
                final Optional<Book> bookOptional = bookService.getBook(item.getIsbn());
                if (!bookOptional.isPresent()) {
                    throw new ValidationException("Book with isbn <%s> and title <%s> does not exist", item.getIsbn());
                }
                final Book book = bookOptional.get();

                if (item.getQuantity() > book.getTotalInventory()) {
                    throw new ValidationException("Order quantity for book <%s> is greater than total inventory", book.getTitle());
                }

                // create copy of book
                final Book oldBook = book.toBuilder().build();

                // update total inventory of book
                book.setTotalInventory(book.getTotalInventory() - item.getQuantity());
                bookService.updateBook(book);

                // collect books with previous inventories so we can reupdate if error is thrown
                oldBooks.add(oldBook);

                // create order item
                orderItemDao.createOrderItem(item);
            }

            cartService.deleteCartForCustomer(order.getUsername());
        } catch (final DataAccessException da) {
            System.out.println(da.toString());

            // delete payment info
            if (order.getPaymentType().equals("CREDIT")) {
                paymentDao.deletePayment(paymentId);
            }

            // update books with old quantities
            for (final Book book : oldBooks) {
                bookService.updateBook(book);
            }

            // delete stale order items
            orderItemDao.deleteOrderItemsForOrderId(orderId);
            throw new ValidationException("Could not create order items for order <%s>", Integer.toString(orderId));
        }
        order.setOrderId(orderId);
        return order;
    }

    public Optional<Order> getOrder(final int orderId) {
        return orderDao.getOrder(orderId);
    }

    public List<OrderItem> getOrderItemsForOrderId(final int orderId) {
        return orderItemDao.getOrderItemsForOrderId(orderId);
    }

}
