package org.csci4050.bookstore.Bookstore.dao;

import org.csci4050.bookstore.Bookstore.mappers.PromotionMapper;
import org.csci4050.bookstore.Bookstore.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class PromotionDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PromotionDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createPromotion(final Promotion promotion) {
        this.jdbcTemplate.update("insert into promotion(expire_date,percent_off,promo_code) " +
                        "values(?,?,?);", promotion.getExpireDate(), promotion.getPercentOff(), promotion.getPromoCode());
    }

    public void updatePromotion(final Promotion promotion) {
        final String sql = "update promotion set expire_date=?, percent_off=?, promo_code=? where promo_id=?";
        jdbcTemplate.update(sql, promotion.getExpireDate(), promotion.getPercentOff(), promotion.getPromoCode(), promotion.getPromoId());
    }

    public Optional<Promotion> getPromotion(final int promoId) {
        final List<Promotion> promotion = this.jdbcTemplate.query("select * from promotion where promo_id=?", new Object[] {promoId}, new PromotionMapper());
        return promotion.stream().findAny();
    }

    public Optional<Promotion> getPromotionWithPromoCode(final int promoCode) {
        final List<Promotion> promotions = this.jdbcTemplate.query("select * from promotion where promo_code=?", new Object[] {promoCode}, new PromotionMapper());
        return promotions.stream().findAny();
    }

    public List<Promotion> getPromotions() {
        return this.jdbcTemplate.query("select * from promotion", new PromotionMapper());
    }

    public void deletePromotion(final int promoCode) {
        this.jdbcTemplate.query("delete from promotion where promo_code=?", new Object[] {promoCode}, new PromotionMapper());
    }
}
