package org.csci4050.bookstore.Bookstore.controllers;

import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Book;
import org.csci4050.bookstore.Bookstore.model.CartItem;
import org.csci4050.bookstore.Bookstore.service.BookService;
import org.csci4050.bookstore.Bookstore.service.CartService;
import org.csci4050.bookstore.Bookstore.service.VendorService;
import org.csci4050.bookstore.Bookstore.viewmodel.CartViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private BookService bookService;

    @Autowired
    private VendorService vendorService;

    /**
     * Example JSON request body:
     * {
     * 	"isbn": "9780091889487",
     * 	"cUsername": "jmkovachi",
     * 	"quantity": 3
     * }
     */
    @RequestMapping(value = "/add-item", method = RequestMethod.POST)
    public ResponseEntity<Object> addCartItem(@RequestBody CartItem cartItem) throws ValidationException {
        final Optional<CartItem> retrieveItem = cartService.getCartItem(cartItem.getCUsername(), cartItem.getIsbn());
        if (retrieveItem.isPresent()) {
            final CartItem preItem = retrieveItem.get();
            preItem.setQuantity(preItem.getQuantity() + 1);
            cartService.updateCartItem(preItem);
            return new ResponseEntity<>(preItem, new HttpHeaders(), HttpStatus.OK);
        } else {
            cartService.insertCartItem(cartItem);
            return new ResponseEntity<>(cartItem, new HttpHeaders(), HttpStatus.OK);
        }
    }

    /**
     * Ex JSON:
     * {
     * 	"isbn": "9780091889487",
     * 	"cUsername": "jmkovachi",
     * 	"quantity": 1
     * }
     */
    @RequestMapping(value = "/update-item", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCartItem(@RequestBody CartItem cartItem) throws ValidationException {
        cartService.updateCartItem(cartItem);
        return new ResponseEntity<>(cartItem, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete-item/{username}/{isbn}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCartItem(@PathVariable final String isbn, @PathVariable final String username) throws ValidationException {
        cartService.deleteCartItem(isbn, username);
        return new ResponseEntity<>("", new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView cartPage(final Principal principal, final Authentication authentication) throws ValidationException {
        // Principal is a bean defined by spring security, we can use it to get authentication details
        final String username = principal.getName();
        final List<CartItemWithBook> cartItems = cartService.getCartForCustomer(username).stream()
                .map(this::transformToCartItemWithBook)
                .collect(Collectors.toList());

        // use java streams to calculate total price of all items
        final Double totalAmount = cartItems.stream()
                .map(CartItemWithBook::getCartItem)
                .map(CartItem::getFinalPrice)
                .reduce(0.0, (c1, c2) -> c1 + c2);

        final CartViewModel cartViewModel = CartViewModel.builder()
                .username(username)
                .cartItems(cartItems)
                .totalAmount(totalAmount)
                .build();
        return new ModelAndView("views/cart", "cart", cartViewModel);
    }

    private CartItemWithBook transformToCartItemWithBook(final CartItem cartItem) {
        final Book book = bookService.getBook(cartItem.getIsbn()).get();
        final String publisher = vendorService.getVendor(book.getVUsername()).get().getCompany();
        return CartItemWithBook.builder()
                .cartItem(cartItem)
                .singleFinalPrice(cartItem.getFinalPrice() / cartItem.getQuantity())
                .singleOriginalPrice(cartItem.getOriginalPrice() / cartItem.getQuantity())
                .publisher(publisher)
                .book(book)
                .build();
    }

    @Data
    @Builder
    public static class CartItemWithBook {
        private CartItem cartItem;
        private String publisher;
        private double singleFinalPrice;
        private double singleOriginalPrice;
        private Book book;
    }

}
