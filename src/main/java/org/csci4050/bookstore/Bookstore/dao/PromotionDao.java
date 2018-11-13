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

    public void updateUser(final Promotion promotion) {
        final String sql = "update promotion set expire_date=?, percent_off=?, promo_code=? where promo_id=?";
        jdbcTemplate.update(sql, promotion.getExpireDate(), promotion.getPercentOff(), promotion.getPromoCode(), promotion.getPromoId());
    }

    public Optional<Promotion> getPromotion(final String promoId) {
        final List<Promotion> promotion = this.jdbcTemplate.query("select * from promotion where promo_id=?", new Object[] {promoId}, new PromotionMapper());
        return promotion.stream().findAny();
    }

    public List<Promotion> getPromotions() {
        return this.jdbcTemplate.query("select * from promotion", new PromotionMapper());
    }

    public void deletePromotion(final String promoId) {
        this.jdbcTemplate.query("delete from promotion where promo_id=?", new Object[] {promoId}, new PromotionMapper());
    }
}
