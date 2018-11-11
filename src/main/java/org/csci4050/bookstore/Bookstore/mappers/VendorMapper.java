package org.csci4050.bookstore.Bookstore.mappers;

import org.csci4050.bookstore.Bookstore.model.Vendor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VendorMapper implements RowMapper<Vendor> {

    @Override
    public Vendor mapRow(final ResultSet rs, final int rownumber) throws SQLException {
        final Vendor vendor = Vendor.builder()
                .address(rs.getString("address"))
                .company(rs.getString("company"))
                .build();
        return (Vendor) UserMapper.setUserFromResultSet(vendor, rs);
    }

}