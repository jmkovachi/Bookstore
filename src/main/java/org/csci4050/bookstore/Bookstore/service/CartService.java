package org.csci4050.bookstore.Bookstore.service;

import org.csci4050.bookstore.Bookstore.dao.CartDao;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.CartItem;
import org.csci4050.bookstore.Bookstore.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CartService {

    private CartDao cartDao;

    private CustomerService customerService;

    @Autowired
    public CartService(final CartDao cartDao, final CustomerService customerService) {
        this.cartDao = cartDao;
        this.customerService = customerService;
    }

    public void insertCartItem(final CartItem cartItem) throws ValidationException {
        this.checkCustomerExists(cartItem.getCUsername());

        final Optional<CartItem> retrieveCartItem = cartDao.getCartItem(cartItem.getIsbn(), cartItem.getCUsername());
        if (retrieveCartItem.isPresent()) {
            throw new ValidationException("Cart item with isbn <%s> and username <%s> already exists", cartItem.getIsbn(), cartItem.getCUsername());
        }

        cartDao.createCartItem(cartItem);
    }

    public List<CartItem> getCartForCustomer(final String cUsername) throws ValidationException {
        this.checkCustomerExists(cUsername);

        return cartDao.getCartForCustomer(cUsername);
    }

    public void updateCartItem(final CartItem cartItem) throws ValidationException {
        final Optional<CartItem> retrieveCartItem = cartDao.getCartItem(cartItem.getIsbn(), cartItem.getCUsername());
        if (!retrieveCartItem.isPresent()) {
            throw new ValidationException("Cart item with isbn <%s> and username <%s> does not exist", cartItem.getIsbn(), cartItem.getCUsername());
        }

        cartDao.updateCartItem(cartItem);
    }

    private void checkCustomerExists(final String cUsername) throws ValidationException {
        final Optional<Customer> customer = customerService.getCustomer(cUsername);
        if (!customer.isPresent()) {
            throw new ValidationException("Customer with username <%s> not found", cUsername);
        }
    }
}
