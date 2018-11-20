package org.csci4050.bookstore.Bookstore.service;

import org.csci4050.bookstore.Bookstore.dao.PromotionDao;
import org.csci4050.bookstore.Bookstore.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PromotionService {

    private PromotionDao promotionDao;

    @Autowired
    public PromotionService(final PromotionDao promotionDao) {
        this.promotionDao = promotionDao;
    }

    public Optional<Promotion> getPromotion(final int promoId) {
        return this.promotionDao.getPromotion(promoId);
    }
}
