package org.csci4050.bookstore.Bookstore.mappers;

import org.csci4050.bookstore.Bookstore.model.Promotion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PromotionMapper implements RowMapper<Promotion> {

    @Override
    public Promotion mapRow(final ResultSet rs, final int rownumber) throws SQLException {
        return Promotion.builder()
                .expireDate(rs.getDate("expire_date"))
                .percentOff(rs.getDouble("percent_off"))
                .promoCode(rs.getString("promo_code"))
                .promoId(rs.getInt("promo_id"))
                .build();
    }

}
