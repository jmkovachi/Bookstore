package org.csci4050.bookstore.Bookstore.service;

import org.csci4050.bookstore.Bookstore.dao.CartDao;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Book;
import org.csci4050.bookstore.Bookstore.model.CartItem;
import org.csci4050.bookstore.Bookstore.model.Customer;
import org.csci4050.bookstore.Bookstore.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CartService {

    private CartDao cartDao;

    private CustomerService customerService;

    private BookService bookService;

    private PromotionService promotionService;

    @Autowired
    public CartService(final CartDao cartDao, final CustomerService customerService, final BookService bookService, final PromotionService promotionService) {
        this.cartDao = cartDao;
        this.customerService = customerService;
        this.bookService = bookService;
        this.promotionService = promotionService;
    }

    public void insertCartItem(final CartItem cartItem) throws ValidationException {
        this.checkCustomerExists(cartItem.getCUsername());

        final Optional<CartItem> retrieveCartItem = cartDao.getCartItem(cartItem.getIsbn(), cartItem.getCUsername());
        if (retrieveCartItem.isPresent()) {
            throw new ValidationException("Cart item with isbn <%s> and username <%s> already exists", cartItem.getIsbn(), cartItem.getCUsername());
        }

        final Optional<Book> retrieveBook = bookService.getBook(cartItem.getIsbn());
        if (!retrieveBook.isPresent()) {
            throw new ValidationException("Book with isbn <%s> does not exist", cartItem.getIsbn());
        }

        this.setPrices(cartItem);
        cartDao.createCartItem(cartItem);
    }

    public List<CartItem> getCartForCustomer(final String cUsername) throws ValidationException {
        this.checkCustomerExists(cUsername);
        return cartDao.getCartForCustomer(cUsername);
    }

    public void updateCartItem(final CartItem cartItem) throws ValidationException {
        this.checkCartItemExists(cartItem.getIsbn(), cartItem.getCUsername());
        this.setPrices(cartItem);
        cartDao.updateCartItem(cartItem);
    }

    public void deleteCartItem(final String isbn, final String username) throws ValidationException {
        this.checkCartItemExists(isbn, username);
        cartDao.deleteCartItem(isbn, username);
    }

    private void checkCustomerExists(final String cUsername) throws ValidationException {
        final Optional<Customer> customer = customerService.getCustomer(cUsername);
        if (!customer.isPresent()) {
            throw new ValidationException("Customer with username <%s> not found", cUsername);
        }
    }

    private void checkCartItemExists(final String isbn, final String username) throws ValidationException {
        final Optional<CartItem> retrieveCartItem = cartDao.getCartItem(isbn, username);
        if (!retrieveCartItem.isPresent()) {
            throw new ValidationException("Cart item with isbn <%s> and username <%s> does not exist", isbn, username);
        }
    }

    private void applyPromotion(final Double originalPrice, final Promotion promotion, final CartItem cartItem) {
        cartItem.setFinalPrice(originalPrice * promotion.getPercentOff());
    }

    private void setPrices(final CartItem cartItem) throws ValidationException {
        final Optional<Book> retrieveBook = bookService.getBook(cartItem.getIsbn());
        if (!retrieveBook.isPresent()) {
            throw new ValidationException("Book with isbn <%s> does not exist", cartItem.getIsbn());
        }

        final Book book = retrieveBook.get();
        final Double originalPrice = cartItem.getQuantity() * book.getPrice();
        cartItem.setOriginalPrice(originalPrice);
        if (book.getPromoId() != null) {
            final Optional<Promotion> promotion = promotionService.getPromotion(book.getPromoId());
            if (promotion.isPresent()) {
                this.applyPromotion(originalPrice, promotion.get(), cartItem);
            } else {
                throw new ValidationException("Promotion with promo id <%s> does not exist", Integer.toString(book.getPromoId()));
            }
        } else {
            cartItem.setFinalPrice(originalPrice);
        }
    }
}
