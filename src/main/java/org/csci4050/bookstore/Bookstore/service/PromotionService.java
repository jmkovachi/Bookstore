package org.csci4050.bookstore.Bookstore.service;

import org.csci4050.bookstore.Bookstore.dao.PromotionDao;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.CartItem;
import org.csci4050.bookstore.Bookstore.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PromotionService {

    private PromotionDao promotionDao;

    private CartService cartService;

    @Autowired
    public PromotionService(final PromotionDao promotionDao, final CartService cartService) {
        this.promotionDao = promotionDao;
        this.cartService = cartService;
    }

    public Optional<Promotion> getPromotion(final int promoId) {
        return this.promotionDao.getPromotion(promoId);
    }

    public Optional<Promotion> getPromotionWithPromoCode(final int promoCode) {
        return this.promotionDao.getPromotionWithPromoCode(promoCode);
    }

    public void createPromotion(final Promotion promotion) {
        promotionDao.createPromotion(promotion);
    }

    public void updatePromotion(final Promotion promotion) {
        promotionDao.updatePromotion(promotion);
    }

    public void updateCartWithPromotion(final Promotion promotion, final String username) throws ValidationException {
        final List<CartItem> cartItems = cartService.getCartForCustomer(username);
        for (final CartItem item : cartItems) {
            final Double promoPrice = item.getOriginalPrice()*((100-promotion.getPercentOff())/100);
            item.setFinalPrice(promoPrice);
            cartService.updateCartItem(item);
        }
    }
}
