package org.csci4050.bookstore.Bookstore.service;

import org.csci4050.bookstore.Bookstore.dao.OrderDao;
import org.csci4050.bookstore.Bookstore.dao.OrderItemDao;
import org.csci4050.bookstore.Bookstore.dao.PaymentDao;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

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

    private JavaMailSender javaMailSender;

    @Autowired
    public OrderService(final OrderDao orderDao, final OrderItemDao orderItemDao,
                        final CustomerService customerService, final PaymentDao paymentDao,
                        final BookService bookService, final CartService cartService,
                        final ShippingAddressService shippingAddressService, final JavaMailSender javaMailSender) {
        this.orderDao = orderDao;
        this.orderItemDao = orderItemDao;
        this.customerService = customerService;
        this.paymentDao = paymentDao;
        this.bookService = bookService;
        this.cartService = cartService;
        this.shippingAddressService = shippingAddressService;
        this.javaMailSender = javaMailSender;
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

        if (!order.getPaymentType().equals("CASH")) {
            // create shipping address
            int shippingAddressId = shippingAddressService.createShippingAddress(shippingAddress);
            order.setAddressId(shippingAddressId);
        }

        for (final OrderItem item : orderItems) {
            // hacky, but we'll use this for now
            final Optional<Book> bookOptional = bookService.getBook(item.getIsbn());
            if (!bookOptional.isPresent()) {
                throw new ValidationException("Book with isbn <%s> and title <%s> does not exist", item.getIsbn());
            }
            if (item.getFinalPrice() == null) {
                item.setFinalPrice(bookOptional.get().getPrice());
            }
        }

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

    public void sendOrderConfirmationEmail(final int orderId) throws ValidationException {
        final Optional<Order> optionalOrder = orderDao.getOrder(orderId);
        if (!optionalOrder.isPresent()) {
            throw new ValidationException("Order with id <%s> does not exist", Integer.toString(orderId));
        }

        final Order order = optionalOrder.get();
        final List<OrderItem> orderItems = orderItemDao.getOrderItemsForOrderId(order.getOrderId());
        final Customer customer = customerService.getCustomer(order.getUsername()).get();
        final ShippingAddress shippingAddress = shippingAddressService.getShippingAddress(order.getAddressId()).get();
        javaMailSender.send(mimeMessage -> {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            message.setTo(customer.getEmail());
            message.setSubject("Order #" + order.getOrderId() + " confirmation from Bookstore.com");
            final String html = createConfirmationHtml(order, orderItems, customer, shippingAddress);
            message.setText(html, true);
        });
    }

    public Optional<Order> getOrder(final int orderId) {
        return orderDao.getOrder(orderId);
    }

    public List<OrderItem> getOrderItemsForOrderId(final int orderId) {
        return orderItemDao.getOrderItemsForOrderId(orderId);
    }

    private String createConfirmationHtml(final Order order, final List<OrderItem> orderItems,
                                          final Customer customer, final ShippingAddress shippingAddress) {
        final StringBuilder str = new StringBuilder();
        str.append("<h1> Thanks for ordering with Bookstore.com, " + customer.getFirstName() + ".");
        str.append("<h2> Confirmation for order #" + order.getOrderId() + " </h2>");
        str.append("<h3> Total: $" + order.getTotal() + "</h3>");
        str.append("<br>");
        str.append("<h3> Number of items: " + orderItems.size() + "</h3>");
        for (final OrderItem item : orderItems) {
            str.append("<div> Isbn: " + item.getIsbn() + " | Quantity: " + item.getQuantity() + "</div>");
        }
        str.append("<h3> Shipping address </h3>");
        str.append("<div> Address: " + shippingAddress.getAddress() + " </div>");
        str.append("<div> City: " + shippingAddress.getCity() + "| State: " + shippingAddress.getState() + "</div>");
        str.append("<div> Zip: " + shippingAddress.getZip() + "</div>");
        str.append("<a href=\"http://localhost:8080/order/confirm/" + order.getOrderId() + "\">Link to Order Confirmation</a>");
        return str.toString();
    }

}
